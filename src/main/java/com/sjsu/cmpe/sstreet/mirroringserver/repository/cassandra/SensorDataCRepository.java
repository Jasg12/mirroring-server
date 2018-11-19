package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataCRepository extends CassandraRepository<SensorData, String> {

    Slice<SensorData> findAllByIdSmartClusterAndIdSmartNode(Integer idSmartCluster, Integer idSmartNode);

}
