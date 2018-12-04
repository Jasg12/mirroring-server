package com.sjsu.cmpe.sstreet.mirroringserver.repository.cassandra;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorDataByNode;
import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorDataBySensor;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

public interface SensorDataBySensorRepo extends CassandraRepository<SensorDataBySensor, String> {

    Slice<SensorDataBySensor> findAllByIdSensor(Integer idSensor, Pageable page);

    @Query("SELECT * FROM sensor_data_by_sensor WHERE idSensor = :idSensor AND timestamp > :from AND timestamp < :to")
    Slice<SensorDataBySensor> findByIdSensorAndTimeRange(@Param("idSensor") Integer idSensor, @Param("from") Long from, @Param("to") Long to, Pageable page);

}
