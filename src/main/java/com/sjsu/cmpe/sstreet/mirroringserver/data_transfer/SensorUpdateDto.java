package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Date;

public class SensorUpdateDto {

    private Integer idSensor;

    private LocationDto location;

    private SmartNodeDto smartNode;

    public SensorUpdateDto(
        LocationDto location,
        SmartNodeDto smartNode
    ) {

        this.location = location;
        this.smartNode = smartNode;
    }

    public SensorUpdateDto() {

    }

    public Integer getIdSensor() {

        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {

        this.idSensor = idSensor;
    }

    public LocationDto getLocation() {

        return location;
    }

    public void setLocation(LocationDto location) {

        this.location = location;
    }

    public SmartNodeDto getSmartNode() {

        return smartNode;
    }

    public void setSmartNode(SmartNodeDto smartNode) {

        this.smartNode = smartNode;
    }
}
