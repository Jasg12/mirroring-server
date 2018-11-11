package com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql;

import com.sjsu.cmpe.sstreet.webserver.model.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {

}
