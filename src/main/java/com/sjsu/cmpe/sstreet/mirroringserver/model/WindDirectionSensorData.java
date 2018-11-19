package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_wind_direction_data")
public class WindDirectionSensorData extends SensorData {

    private WindDirectionType direction;

    public WindDirectionSensorData() {

    }

    public WindDirectionType getDirection() {

        return direction;
    }

    public void setDirection(WindDirectionType direction) {

        this.direction = direction;
    }
}