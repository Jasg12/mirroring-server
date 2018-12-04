package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorDataByCluster;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorDataByClusterRepo extends CassandraRepository<SensorDataByCluster, String> {

    Slice<SensorDataByCluster> findAllByIdSmartCluster(Integer idSmartCluster, Pageable page);

    List<SensorDataByCluster> findAll();

    @Query("SELECT * FROM sensor_data_by_cluster WHERE idSmartCluster = :idSmartCluster AND timestamp > :from AND timestamp < :to")
    Slice<SensorDataByCluster> findByIdSmartClusterAndTimeRange(@Param("idSmartCluster") Integer idSmartCluster, @Param("from") Long from, @Param("to") Long to, Pageable page);

}
