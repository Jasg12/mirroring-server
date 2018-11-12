package com.sjsu.cmpe.sstreet.mirroringserver.service.infrastructure_manager;


import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.LocationDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeDto;
import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartNodeUpdateDto;
import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartNode;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.SmartNodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SmartNodeIMService {

    private SmartNodeRepository smartNodeRepository;


    private ModelMapper modelMapper;


    @Autowired
    public SmartNodeIMService(SmartNodeRepository smartNodeRepository) {
        this.smartNodeRepository = smartNodeRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<String> createSmartNode(SmartNodeDto smartNodeDto) {

        SmartNode smartNode = modelMapper.map(smartNodeDto, SmartNode.class);
        SmartNode savedSmartNode = smartNodeRepository.save(smartNode);

        if(null != savedSmartNode){

            return ResponseEntity.ok("Smart Node Created with ID: "+savedSmartNode.getIdSmartNode());
        }else{

            return new ResponseEntity<>("A Smart Node at requested location already exists", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> updateSmartNode(SmartNodeUpdateDto smartNodeUpdateDto){

        SmartNode smartNode = modelMapper.map(smartNodeUpdateDto, SmartNode.class);

        Optional<SmartNode> smartNodeResult = smartNodeRepository.findById(smartNode.getIdSmartNode());

        smartNodeResult.ifPresent(result->{
            smartNode.setName(result.getName());
            smartNode.setMake(result.getMake());
            smartNode.setModel(result.getModel());
            smartNode.setInstallationDate(result.getInstallationDate());
            smartNode.setSmartCluster(result.getSmartCluster());

        });

        if(smartNodeResult.isPresent()){

            if(null != smartNodeRepository.save(smartNode)){
                return ResponseEntity.ok("Smart Node updated");

            }else{
                return new ResponseEntity<>("Smart Node Update Failed",HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            return new ResponseEntity<>("Smart Node with ID: " + smartNode.getIdSmartNode()+" does not exist",HttpStatus.BAD_REQUEST);
        }

    }

    public List<SmartNodeDto> getAllSmartNodes(){

        Iterable<SmartNode> smartNodeIterable = smartNodeRepository.findAll();
        List<SmartNodeDto> smartNodeList  = new ArrayList<>();

        smartNodeIterable.forEach(smartNode ->
            smartNodeList.add(modelMapper.map(smartNode, SmartNodeDto.class))

        );

        return smartNodeList;
    }

    public SmartNodeDto getSmartNodeById(Integer id){

        Optional<SmartNode> smartNodeOptional = smartNodeRepository.findById(id);
        List<SmartNodeDto> smartNodeDto = new ArrayList<>();

        if(!smartNodeOptional.isPresent()) {

            return null;
        }

        smartNodeOptional.ifPresent(smartNode ->
            smartNodeDto.add(modelMapper.map(smartNode,SmartNodeDto.class))

        );

        return smartNodeDto.get(0);

    }

    public SmartNodeDto getSmartNodeByName(String name){

        Optional<SmartNode> smartNodeOptional = smartNodeRepository.findByName(name);
        List<SmartNodeDto> smartNodeDtoList = new ArrayList<>();

        if(!smartNodeOptional.isPresent()) {

            return null;
        }

        smartNodeOptional.ifPresent(smartNode ->
                smartNodeDtoList.add(modelMapper.map(smartNode,SmartNodeDto.class))

        );

        return smartNodeDtoList.get(0);

    }

    public SmartNodeDto getSmartNodeByLocation(LocationDto locationDto){

        Location location = modelMapper.map(locationDto, Location.class);
        SmartNode smartNode = smartNodeRepository.findByLocation(location);

        return modelMapper.map(smartNode, SmartNodeDto.class);


    }

    public List<SmartNodeDto> getSmartNodeBySmartCluster(SmartClusterDto smartClusterDto) {

        SmartCluster smartCluster = modelMapper.map(smartClusterDto, SmartCluster.class);

        List<SmartNode> smartNodes = smartNodeRepository.findBySmartCluster(smartCluster);

        List<SmartNodeDto> smartNodeDtoList = new ArrayList<>();
        smartNodes.forEach(smartNode ->
            smartNodeDtoList.add(modelMapper.map(smartNode, SmartNodeDto.class))
        );

        return smartNodeDtoList;

    }

    public ResponseEntity<String> deleteSmartNodeById(Integer id){

        smartNodeRepository.deleteById(id);
        return ResponseEntity.ok("Smart Node Successfully Deleted");

    }

    public ResponseEntity<String> deleteSmartNodeByName(String name){

        smartNodeRepository.deleteByName(name);
        return ResponseEntity.ok("Smart Node Successfully Deleted");

    }

    public ResponseEntity<String> deleteSmartNodeBySmartCluster(SmartClusterDto smartClusterDto){

        SmartCluster smartCluster = modelMapper.map(smartClusterDto, SmartCluster.class);

        smartNodeRepository.deleteBySmartCluster(smartCluster);
        return ResponseEntity.ok("Smart Node Successfully Deleted");

    }



}
