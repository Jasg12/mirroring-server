package com.sjsu.cmpe.sstreet.mirroringserver.service.infrastructure_manager;

import com.sjsu.cmpe.sstreet.mirroringserver.data_transfer.SmartClusterDto;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartCluster;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.LocationRepository;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.SmartClusterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SmartClusterService {

    private SmartClusterRepository smartClusterRepository;
    private LocationRepository locationRepository;
    private ModelMapper modelMapper;


    @Autowired
    public SmartClusterService(SmartClusterRepository smartClusterRepository, LocationRepository locationRepository, ModelMapper modelMapper) {
        this.smartClusterRepository = smartClusterRepository;
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

//    public ResponseEntity<String> createSmartCluster(SmartClusterDto smartClusterDto) {
//
//
//
//
//    }



}
