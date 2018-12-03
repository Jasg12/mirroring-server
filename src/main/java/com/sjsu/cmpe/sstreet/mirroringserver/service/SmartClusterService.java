package com.sjsu.cmpe.sstreet.mirroringserver.service;


import com.sjsu.cmpe.sstreet.mirroringserver.model.Location;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.LocationRepository;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.SmartClusterRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
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
    private LocationRepository locationRepository;
    private Logger log;


    private ModelMapper modelMapper;

    public SmartClusterService(
        SmartClusterRepository smartClusterRepository,
        LocationRepository locationRepository,
        Logger log
    ) {

        this.smartClusterRepository = smartClusterRepository;
        this.locationRepository = locationRepository;
        this.log = log;
    }

    public SmartCluster createSmartCluster(SmartCluster smartCluster) {

        Location location = smartCluster.getLocation();
        if (location != null){
            location = locationRepository.save(location);
        }
        smartCluster.setLocation(location);
        SmartCluster savedSmartCluster = smartClusterRepository.save(smartCluster);
        log.info("New Cluster have created cluster:{}", savedSmartCluster);

        return savedSmartCluster;
    }

    public SmartCluster updateSmartCluster(SmartCluster smartCluster){

        SmartCluster currentCluster = smartClusterRepository.findById(smartCluster.getIdSmartCluster()).get();
        currentCluster.setName(smartCluster.getName());
        currentCluster.setModel(smartCluster.getModel());
        currentCluster.setMake(smartCluster.getMake());
        currentCluster.setUrl(smartCluster.getUrl());
        currentCluster.setIdSmartCluster(smartCluster.getIdSmartCluster());

        Location currentLocation = currentCluster.getLocation();
        currentLocation.setIdLocation(smartCluster.getLocation().getIdLocation());
        currentLocation.setState(smartCluster.getLocation().getState());
        currentLocation.setCity(smartCluster.getLocation().getCity());
        currentLocation.setStreet(smartCluster.getLocation().getStreet());
        currentLocation.setLatitude(smartCluster.getLocation().getLatitude());
        currentLocation.setLongitude(smartCluster.getLocation().getLongitude());
        currentLocation.setZipCode(smartCluster.getLocation().getZipCode());
        locationRepository.save(currentLocation);
        currentCluster = smartClusterRepository.save(currentCluster);
        log.info("Update cluster:{}", currentCluster);

        return currentCluster;
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
