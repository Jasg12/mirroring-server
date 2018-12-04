package com.sjsu.cmpe.sstreet.mirroringserver.service;

import com.sjsu.cmpe.sstreet.mirroringserver.model.*;

import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorStatusByTimestampRepository;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra.SensorStatusRepository;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.*;

import com.sjsu.cmpe.sstreet.mirroringserver.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class SensorService {

    private SensorRepository sensorRepository;
    private SmartNodeRepository smartNodeRepository;
    private SensorStatusRepository sensorStatusRepository;
    private SensorStatusByTimestampRepository sensorStatusByTimestampRepository;
    private LocationRepository locationRepository;

    @Autowired
    public SensorService(
        SensorRepository sensorRepository,
        SmartNodeRepository smartNodeRepository,
        SensorStatusRepository sensorStatusRepository,
        SensorStatusByTimestampRepository sensorStatusByTimestampRepository,
        LocationRepository locationRepository)
    {
        this.sensorRepository = sensorRepository;
        this.smartNodeRepository = smartNodeRepository;
        this.sensorStatusRepository = sensorStatusRepository;
        this.sensorStatusByTimestampRepository = sensorStatusByTimestampRepository;
        this.locationRepository = locationRepository;
    }

    public Sensor createSensor(Sensor sensor) {
        Location location = sensor.getLocation();
        location = locationRepository.save(location);
        sensor = sensorRepository.save(sensor);

        return sensor;
    }

    public Sensor updateSensor(Sensor sensor) {

        Location location = sensor.getLocation();
        location = locationRepository.save(location);

        return sensorRepository.save(sensor);
    }

    public List<Sensor> getAllSensors() {

        Iterable<Sensor> sensorIterable = sensorRepository.findAll();
        List<Sensor> sensorList = new ArrayList<>();

        sensorIterable.forEach(sensor ->
                sensorList.add(sensor)
        );

        return sensorList;
    }

    public Sensor getSensorById(Integer id) {

        Optional<Sensor> sensorOptional = sensorRepository.findById(id);
        List<Sensor> sensor = new ArrayList<>();

        if (!sensorOptional.isPresent()) {

            return null;
        }


        return sensor.get(0);

    }

    public List<Sensor> getSensorBySmartNode(SmartNode smartNode) {

        return sensorRepository.findBySmartNode(smartNode);

    }

    public List<Sensor> getSensorBySmartCluster(SmartCluster smartCluster) {

        List<Sensor> sensorList = new ArrayList<>();

        List<SmartNode> smartNodeList = smartNodeRepository.findBySmartCluster(smartCluster);

        for (SmartNode smartNode:smartNodeList)
            sensorList.addAll(sensorRepository.findBySmartNode(smartNode));

       return sensorList;

    }

    public ResponseEntity<String> deleteSensorById(Integer id) {

        sensorRepository.deleteById(id);
        return ResponseEntity.ok("Sensor Successfully Deleted");

    }

    public ResponseEntity<String> deleteSensorBySmartNode(SmartNode smartNode) {

        sensorRepository.deleteBySmartNode(smartNode);

        return ResponseEntity.ok("Sensor Successfully Deleted");

    }

    public ResponseEntity<String> deleteSensorBySmartCluster(SmartCluster smartCluster) {

        List<SmartNode> smartNodeList = smartNodeRepository.findBySmartCluster(smartCluster);

        for (SmartNode smartNode:smartNodeList)
            sensorRepository.deleteBySmartNode(smartNode);

        return ResponseEntity.ok("Sensor Successfully Deleted");

    }

    public List<SensorStatus> getAll(){

//        sensorStatusByTimestampRepository.save(new SensorStatusByTimestamp(1,2,3,(long) 20181129,true ));
//        sensorStatusByTimestampRepository.save(new SensorStatusByTimestamp(1,2,3,(long) 20181128,true ));
//        sensorStatusByTimestampRepository.save(new SensorStatusByTimestamp(1,2,3,(long) 20181126,true ));
        sensorStatusRepository.save(new SensorStatus(1,2,3,(long) 20181129,true ));
        sensorStatusRepository.save(new SensorStatus(1,2,3,(long) 20181128,true ));
        sensorStatusRepository.save(new SensorStatus(1,2,3,(long) 20181126,true ));


        //return sensorStatusByTimestampRepository.findByTimestampBeforeAndTimestampAfter((long)20181130,(long)20181126);
        return sensorStatusRepository.findAll();

    }

    public List<Sensor> getSensorsByClusterSerialNumber(String serialNumber){

        return sensorRepository.findAllBySmartNode_SmartCluster_SerialNumber(serialNumber);
    }

}


