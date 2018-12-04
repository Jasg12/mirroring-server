package com.sjsu.cmpe.sstreet.mirroringserver.model;

import com.sjsu.cmpe.sstreet.mirroringserver.model.SensorType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_data_by_node")
public class SensorDataByNode extends SensorData {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public Integer getIdSmartNode(){
        return super.getIdSmartNode();
    }

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    public Long getTimestamp(){
        return super.getTimestamp();
    }

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    public Integer getIdSensor(){
        return super.getIdSensor();
    }

    public SensorDataByNode(
        Integer idSmartCluster,
        Integer idSmartNode,
        SensorType type,
        Long timestamp,
        Integer idSensor,
        SensorValue value
    ) {

        super(idSmartCluster, idSmartNode, type, timestamp, idSensor, value);
    }

    public SensorDataByNode() {

    }

    public SensorDataByNode(SensorData sensorData){
        super(sensorData.getIdSmartCluster(), sensorData.getIdSmartNode(), sensorData.getType(), sensorData.getTimestamp(), sensorData.getIdSensor(), sensorData.getValue());
    }
}
