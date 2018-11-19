package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.WindSpeedSensorData;
import com.sjsu.cmpe.sstreet.webserver.model.WindSpeedSensorData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface WindSpeedDataRepository extends CassandraRepositor<WindSpeedSensorData, String> {

    Slice<WindSpeedSensorData> findAllByIdSmartClusterAndAndIdSensor(Integer idSmartCluster, Integer idSmartNode);
}
