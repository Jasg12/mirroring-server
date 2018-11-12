package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Date;
import java.util.Set;


public class SmartNodeUpdateDto {

    private Integer idSmartNode;

    private LocationDto location;

    private Set<SensorDto> sensorSet;

    public SmartNodeUpdateDto(
        LocationDto location
    ) {

        this.location = location;
    }

    public SmartNodeUpdateDto() {

    }

    public Integer getIdSmartNode() {

        return idSmartNode;
    }

    public void setIdSmartNode(Integer idSmartNode) {

        this.idSmartNode = idSmartNode;
    }

    public LocationDto getLocation() {

        return location;
    }

    public void setLocation(LocationDto location) {

        this.location = location;
    }

    public Set<SensorDto> getSensorSet() {

        return sensorSet;
    }

    public void setSensorSet(Set<SensorDto> sensorSet) {

        this.sensorSet = sensorSet;
    }

}
