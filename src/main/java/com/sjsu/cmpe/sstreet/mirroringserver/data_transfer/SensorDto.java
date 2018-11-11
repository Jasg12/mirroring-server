package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Date;

public class SensorDto {

    private Integer idSensor;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    private String type;

    private LocationDto location;

    private SmartNodeDto smartNode;

    public SensorDto(
        String name,
        String model,
        String make,
        Date installationDate,
        String type,
        LocationDto location,
        SmartNodeDto smartNode
    ) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.type = type;
        this.location = location;
        this.smartNode = smartNode;
    }

    public SensorDto() {

    }

    public Integer getIdSensor() {

        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {

        this.idSensor = idSensor;
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

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
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
