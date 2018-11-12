package com.sjsu.cmpe.sstreet.mirroringserver.data_transfer;

import java.util.Set;

public class SmartClusterUpdateDto {

    private Integer idSmartCluster;

    private LocationDto location;

    private Set<SmartNodeDto> smartNodeSet;

    public SmartClusterUpdateDto(
        LocationDto location
    ) {

        this.location = location;
    }

    public SmartClusterUpdateDto() {

    }

    public Integer getIdSmartCluster() {

        return idSmartCluster;
    }

    public void setIdSmartCluster(Integer idSmartCluster) {

        this.idSmartCluster = idSmartCluster;
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
