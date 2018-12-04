package com.sjsu.cmpe.sstreet.mirroringserver.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
@Table(name = "smart_cluster")
public class SmartCluster {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idSmartCluster;

    private String serialNumber;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    private String url;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="location_idlocation", unique= true, nullable=true, insertable=true, updatable=true)
    private Location location;

    public SmartCluster(String name, String model, String make, Date installationDate, String url, Location location) {
        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.url = url;
        this.location = location;
    }


    public SmartCluster() {

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

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }


    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public String getSerialNumber() {

        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {

        this.serialNumber = serialNumber;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb
            .append("\n")
            .append("{" + "\n")
            .append("    idSmartCluster:" + idSmartCluster + "\n")
            .append("    serialNumber:" + serialNumber + "\n")
            .append("    name:" + name + "\n")
            .append("    model:" + model + "\n")
            .append("    make:" + make + "\n")
            .append("    installationDate:" + installationDate + "\n")
            .append("    url:" + url + "\n")
            .append("}" + "\n");

        return sb.toString();
    }
}
