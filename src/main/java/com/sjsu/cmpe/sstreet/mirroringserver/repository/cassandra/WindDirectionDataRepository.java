package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.webserver.model.WindDirectionSensorData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface WindDirectionDataRepository extends CassandraRepository<WindDirectionSensorData, String> {

    Slice<WindDirectionSensorData> findAllByIdSmartClusterAndAndIdSensor(Integer idSmartCluster, Integer idSmartNode);
}
