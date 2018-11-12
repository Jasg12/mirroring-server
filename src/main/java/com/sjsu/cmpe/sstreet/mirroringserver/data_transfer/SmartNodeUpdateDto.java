package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Date;
import java.util.Set;


public class SmartNodeUpdateDto {

    private Integer idSmartNode;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    private LocationDto location;

    private Set<SensorDto> sensorSet;

    private SmartClusterDto smartCluster;

    public SmartNodeUpdateDto(
        String name,
        String model,
        String make,
        Date installationDate,
        LocationDto location,
        SmartClusterDto smartCluster
    ) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.location = location;
        this.smartCluster = smartCluster;
    }

    public SmartNodeUpdateDto() {

    }

    public Integer getIdSmartNode() {

        return idSmartNode;
    }

    public void setIdSmartNode(Integer idSmartNode) {

        this.idSmartNode = idSmartNode;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public Date getInstallationDate() {

        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {

        this.installationDate = installationDate;
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

    public SmartClusterDto getSmartCluster() {

        return smartCluster;
    }

    public void setSmartCluster(SmartClusterDto smartCluster) {

        this.smartCluster = smartCluster;
    }
}
