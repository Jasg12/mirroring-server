package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_wind_speed_data")
public class WindSpeedSensorData extends SensorData {

    private Integer speed;

    private SpeedType dataType;

    public WindSpeedSensorData() {

    }

    public Integer getSpeed() {

        return speed;
    }

    public void setSpeed(Integer speed) {

        this.speed = speed;
    }

    public SpeedType getDataType() {

        return dataType;
    }

    public void setDataType(SpeedType dataType) {

        this.dataType = dataType;
    }
}
