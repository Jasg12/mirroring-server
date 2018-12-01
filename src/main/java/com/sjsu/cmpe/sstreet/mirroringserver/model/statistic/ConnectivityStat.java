package com.sjsu.cmpe.sstreet.mirroringserver.model.statistic;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Transient;

public class ConnectivityStat {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer id;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private EntityType entityType;

    private ConnectionStatus status;

    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private Long timestamp;

    @Transient
    private Object entity;

    public ConnectivityStat() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public EntityType getEntityType() {

        return entityType;
    }

    public void setEntityType(EntityType entityType) {

        this.entityType = entityType;
    }

    public ConnectionStatus getStatus() {

        return status;
    }

    public void setStatus(ConnectionStatus status) {

        this.status = status;
    }

    public Long getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Long timestamp) {

        this.timestamp = timestamp;
    }

    public Object getEntity() {

        return entity;
    }

    public void setEntity(Object entity) {

        this.entity = entity;
    }
}
