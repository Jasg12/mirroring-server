package com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql;

import com.sjsu.cmpe.sstreet.mirroringserver.model.Sensor;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SmartNode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {

    List<Sensor> findBySmartNode(SmartNode smartNode);

    void deleteBySmartNode(SmartNode smartNode);

    List<Sensor> findAllBySmartNode_SmartCluster_SerialNumber(String serialNumber);

}
