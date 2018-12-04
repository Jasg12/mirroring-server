package com.sjsu.cmpe.sstreet.mirroringserver.model;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_data_by_cluster")
public class SensorDataByCluster extends SensorData {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public Integer getIdSmartCluster(){
        return super.getIdSmartCluster();
    }

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    public Long getTimestamp(){
        return super.getTimestamp();
    }

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    public Integer getIdSensor(){
        return super.getIdSensor();
    }

    public SensorDataByCluster(
        Integer idSmartCluster,
        Integer idSmartNode,
        SensorType type,
        Long timestamp,
        Integer idSensor,
        SensorValue value
    ) {

        super(idSmartCluster, idSmartNode, type, timestamp, idSensor, value);
    }

    public SensorDataByCluster() {
        super();
    }

    public SensorDataByCluster(SensorData sensorData){
        super(sensorData.getIdSmartCluster(), sensorData.getIdSmartNode(), sensorData.getType(), sensorData.getTimestamp(), sensorData.getIdSensor(), sensorData.getValue());
    }
}
