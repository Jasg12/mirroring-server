package com.sjsu.cmpe.sstreet.mirroringserver.service;


import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.SmartClusterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SmartClusterService {

    private SmartClusterRepository smartClusterRepository;


    private ModelMapper modelMapper;


    @Autowired
    public SmartClusterService(SmartClusterRepository smartClusterRepository) {
        this.smartClusterRepository = smartClusterRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<String> createSmartCluster(SmartCluster smartCluster) {

        SmartCluster savedSmartCluster = smartClusterRepository.save(smartCluster);

        if(null != savedSmartCluster){

            return ResponseEntity.ok("Smart Cluster Created with ID: "+savedSmartCluster.getIdSmartCluster());
        }else{

            return new ResponseEntity<>("A Smart Cluster at requested location already exists", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> updateSmartCluster(SmartCluster smartCluster){


        Optional<SmartCluster> smartClusterResult = smartClusterRepository.findById(smartCluster.getIdSmartCluster());

        smartClusterResult.ifPresent(result->{
            smartCluster.setName(result.getName());
            smartCluster.setMake(result.getMake());
            smartCluster.setModel(result.getModel());
            smartCluster.setInstallationDate(result.getInstallationDate());

        });

        if(smartClusterResult.isPresent()){

            if(null != smartClusterRepository.save(smartCluster)){
                return ResponseEntity.ok("Smart Cluster updated");

            }else{
                return new ResponseEntity<>("Smart Cluster  Failed",HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            return new ResponseEntity<>("Smart Cluster with ID: " + smartCluster.getIdSmartCluster()+" does not exist",HttpStatus.BAD_REQUEST);
        }

    }

    public List<SmartCluster> getAllSmartClusters(){

        Iterable<SmartCluster> smartClusterIterable = smartClusterRepository.findAll();
        List<SmartCluster> smartClusterList  = new ArrayList<>();

        smartClusterIterable.forEach(smartCluster ->
            smartClusterList.add(modelMapper.map(smartCluster, SmartCluster.class))

        );

        return smartClusterList;
    }

    public SmartCluster getSmartClusterById(Integer id){

        Optional<SmartCluster> smartClusterOptional = smartClusterRepository.findById(id);
        List<SmartCluster> smartCluster = new ArrayList<>();

        if(!smartClusterOptional.isPresent()) {

            return null;
        }

        smartClusterOptional.ifPresent( smartCluster1 ->

        smartCluster.add(smartCluster1)

        );
        return smartCluster.get(0);

    }

    public SmartCluster getSmartClusterByName(String Name){

        Optional<SmartCluster> smartClusterOptional = smartClusterRepository.findByName(Name);
        List<SmartCluster> smartCluster = new ArrayList<>();

        if(!smartClusterOptional.isPresent()) {

            return null;
        }

        smartClusterOptional.ifPresent( smartCluster1 ->

                smartCluster.add(smartCluster1)

        );

        return smartCluster.get(0);

    }

    public SmartCluster getSmartClusterByLocation(Location location){

        SmartCluster smartCluster = smartClusterRepository.findByLocation(location);

        return modelMapper.map(smartCluster, SmartCluster.class);


    }

    public ResponseEntity<String> deleteSmartClusterById(Integer id){

        smartClusterRepository.deleteById(id);
        return ResponseEntity.ok("Smart Cluster Successfully Deleted");

    }

    public ResponseEntity<String> deleteSmartClusterByName(String name){

        smartClusterRepository.deleteByName(name);
        return ResponseEntity.ok("Smart Cluster Successfully Deleted");

    }



}
