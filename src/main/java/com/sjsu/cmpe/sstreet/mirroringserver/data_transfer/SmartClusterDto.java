package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Date;
import java.util.Set;

public class SmartClusterDto {

    private Integer idSmartCluster;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    private LocationDto location;

    private Set<SmartNodeDto> smartNodeSet;

    public SmartClusterDto(
        String name,
        String model,
        String make,
        Date installationDate,
        LocationDto location
    ) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.location = location;
    }

    public SmartClusterDto() {

    }

    public Integer getIdSmartCluster() {

        return idSmartCluster;
    }

    public void setIdSmartCluster(Integer idSmartCluster) {

        this.idSmartCluster = idSmartCluster;
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

    public Set<SmartNodeDto> getSmartNodeSet() {

        return smartNodeSet;
    }

    public void setSmartNodeSet(Set<SmartNodeDto> smartNodeSet) {

        this.smartNodeSet = smartNodeSet;
    }
}
