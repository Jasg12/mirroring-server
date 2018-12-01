package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorStatus;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorStatusRepository extends CassandraRepository<SensorStatus,Integer> {


    List<SensorStatus> findFirstByIdSensorAndAndIdSmartNodeAndAndIdSmartCluster(Integer idSensor, Integer idSmartNode, Integer idSmartCluster);




}
