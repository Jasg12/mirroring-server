package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "smart_node_status")
public class SmartNodeStatus {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer idSmartCluster;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Integer idSmartNode;

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private Long timestamp;

    private Boolean status;


    public SmartNodeStatus(Integer idSmartCluster, Integer idSmartNode, Long timestamp, Boolean status) {
        this.idSmartCluster = idSmartCluster;
        this.idSmartNode = idSmartNode;
        this.timestamp = timestamp;
        this.status = status;
    }

    public SmartNodeStatus(){

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
