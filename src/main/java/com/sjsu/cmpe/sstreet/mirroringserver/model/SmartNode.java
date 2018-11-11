package com.sjsu.cmpe.sstreet.mirroringserver.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "smart_node")
public class SmartNode {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idSmartNode;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    @OneToOne
    @JoinColumn(name="location_idlocation", unique= true, nullable=true, insertable=true, updatable=true)
    private Location location;

    @OneToMany(mappedBy = "smartNode", cascade = CascadeType.ALL)
    private Set<Sensor> sensorSet;

    @ManyToOne
    @JoinColumn(name = "smart_cluster_idSmartCluster")
    private SmartCluster smartCluster;

    public SmartNode(
        String name,
        String model,
        String make,
        Date installationDate,
        Location location,
        SmartCluster smartCluster
    ) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.location = location;
        this.smartCluster = smartCluster;
    }

    public SmartNode() {

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

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }

    public Set<Sensor> getSensorSet() {

        return sensorSet;
    }

    public void setSensorSet(Set<Sensor> sensorSet) {

        this.sensorSet = sensorSet;
    }

    public SmartCluster getSmartCluster() {

        return smartCluster;
    }

    public void setSmartCluster(SmartCluster smartCluster) {

        this.smartCluster = smartCluster;
    }
}
