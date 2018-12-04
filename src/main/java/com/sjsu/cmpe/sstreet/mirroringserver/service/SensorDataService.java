package com.sjsu.cmpe.sstreet.mirroringserver.service;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorType;
import com.sjsu.cmpe.sstreet.mirroringserver.model.TemperatureType;
import com.sjsu.cmpe.sstreet.mirroringserver.model.TimeRange;
import com.sjsu.cmpe.sstreet.mirroringserver.model.*;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorDataByClusterRepo;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorDataByNodeRepo;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorDataBySensorRepo;
import com.sjsu.cmpe.sstreet.mirroringserver.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SensorDataService {

    private SensorDataByClusterRepo sensorDataByClusterRepo;
    private SensorDataByNodeRepo sensorDataByNodeRepo;
    private SensorDataBySensorRepo sensorDataBySensorRepo;


    public SensorDataService(
        @Autowired SensorDataByClusterRepo sensorDataByClusterRepo,
        @Autowired SensorDataByNodeRepo sensorDataByNodeRepo,
        @Autowired SensorDataBySensorRepo sensorDataBySensorRepo
    ) {
        this.sensorDataByClusterRepo = sensorDataByClusterRepo;
        this.sensorDataByNodeRepo = sensorDataByNodeRepo;
        this.sensorDataBySensorRepo = sensorDataBySensorRepo;
    }

    public SensorData save(SensorData sensorData){
        sensorDataByClusterRepo.save(new SensorDataByCluster(sensorData));
        sensorDataByNodeRepo.save(new SensorDataByNode(sensorData));
        sensorDataBySensorRepo.save(new SensorDataBySensor(sensorData));

        return null;
    }
/*
    public SensorDataSearchResult getDataBySmartClusterAndTimeRange(SensorDataByClusterQuery searchQuery, TimeRange timeRange){
        Slice<SensorDataByCluster> result = sensorDataByClusterRepo.findByIdSmartClusterAndTimeRange(searchQuery.getClusterId(), timeRange.getFrom().getTime(), timeRange.getTo().getTime(), searchQuery.getPage());

        return new SensorDataSearchResult<>(result, searchQuery);
    }

    public SensorDataSearchResult getDataBySmartNodeAndTimeRange(SensorDataByNodeQuery searchQuery, TimeRange timeRange){
        Slice<SensorDataByNode> result = sensorDataByNodeRepo.findByIdSmartNodeAndTimeRange(searchQuery.getNodeId(), timeRange.getFrom().getTime(), timeRange.getTo().getTime(), searchQuery.getPage());

        return new SensorDataSearchResult<>(result, searchQuery);
    }

    public SensorDataSearchResult getDataBySensor(SensorDataBySensorQuery searchQuery){
        Slice<SensorDataBySensor> result = sensorDataBySensorRepo.findAllByIdSensor(searchQuery.getSensorId(), searchQuery.getPage());

        return new SensorDataSearchResult<>(result, searchQuery);
    }

    public SensorDataSearchResult getDataBySensorAndTimeRange(SensorDataBySensorQuery searchQuery, TimeRange timeRange){
        Slice<SensorDataBySensor> result = sensorDataBySensorRepo.findByIdSensorAndTimeRange(searchQuery.getSensorId(), timeRange.getFrom().getTime(), timeRange.getTo().getTime(), searchQuery.getPage());

        return new SensorDataSearchResult<>(result, searchQuery);
    }
    */
}
