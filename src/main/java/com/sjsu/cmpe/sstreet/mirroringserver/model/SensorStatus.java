package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_status")
public class SensorStatus {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer idSmartCluster;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Integer idSmartNode;

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private Integer idSensor;

    @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    private Long timestamp;

    private Boolean status;


    public SensorStatus(Integer idSmartCluster, Integer idSmartNode, Integer idSensor, Long timestamp, Boolean status) {
        this.idSmartCluster = idSmartCluster;
        this.idSmartNode = idSmartNode;
        this.idSensor = idSensor;
        this.timestamp = timestamp;
        this.status = status;
    }

    public SensorStatus(){

    }

    public Integer getIdSmartCluster() {
        return idSmartCluster;
    }

    public void setIdSmartCluster(Integer idSmartCluster) {
        this.idSmartCluster = idSmartCluster;
    }

    public Integer getIdSmartNode() {
        return idSmartNode;
    }

    public void setIdSmartNode(Integer idSmartNode) {
        this.idSmartNode = idSmartNode;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
