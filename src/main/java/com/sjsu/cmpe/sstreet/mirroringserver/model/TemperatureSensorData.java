package com.sjsu.cmpe.sstreet.mirroringserver.model;

import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "sensor_temperature_data")
public class TemperatureSensorData extends com.sjsu.cmpe.sstreet.webserver.model.SensorData {

    private Integer temperature;

    private TemperatureType dataType;

    public TemperatureSensorData() {

    }

    public Integer getTemperature() {

        return temperature;
    }

    public void setTemperature(Integer temperature) {

        this.temperature = temperature;
    }

    public TemperatureType getDataType() {

        return dataType;
    }

    public void setDataType(TemperatureType dataType) {

        this.dataType = dataType;
    }
}
