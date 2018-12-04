package com.sjsu.cmpe.sstreet.mirroringserver.model;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_data_by_sensor")
public class SensorDataBySensor extends SensorData  {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public Integer getIdSensor(){
        return super.getIdSensor();
    }

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    public Long getTimestamp(){
        return super.getTimestamp();
    }

    public SensorDataBySensor(
        Integer idSmartCluster,
        Integer idSmartNode,
        SensorType type,
        Long timestamp,
        Integer idSensor,
        SensorValue value
    ) {

        super(idSmartCluster, idSmartNode, type, timestamp, idSensor, value);
    }

    public SensorDataBySensor() {

    }

    public SensorDataBySensor(SensorData sensorData){
        super(sensorData.getIdSmartCluster(), sensorData.getIdSmartNode(), sensorData.getType(), sensorData.getTimestamp(), sensorData.getIdSensor(), sensorData.getValue());
    }
}
