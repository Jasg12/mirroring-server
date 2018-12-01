package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_status_by_timestamp")
public class SensorStatusByTimestamp {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long timestamp;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Integer idSmartCluster;

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private Integer idSmartNode;

    @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
    private Integer idSensor;

    private Boolean status;


    public SensorStatusByTimestamp(Integer idSmartCluster, Integer idSmartNode, Integer idSensor, Long timestamp, Boolean status) {
        this.idSmartCluster = idSmartCluster;
        this.idSmartNode = idSmartNode;
        this.idSensor = idSensor;
        this.timestamp = timestamp;
        this.status = status;
    }

    public SensorStatusByTimestamp(){

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
