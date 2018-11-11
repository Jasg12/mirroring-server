package com.sjsu.cmpe.sstreet.mirroringserver.model;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer IdLocation;

    private Long longitude;

    private Long latitude;

    private String state;

    private String city;

    private String street;

    private Integer zipCode;

    public Location() {

    }

    public Location(Integer idLocation, Long longitude, Long latitude, String state, String city, String street, Integer zipCode) {

        IdLocation = idLocation;
        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Location(Long longitude, Long latitude, String state, String city, String street, Integer zipCode) {

        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Integer getIdLocation() {

        return IdLocation;
    }

    public void setIdLocation(Integer idLocation) {

        IdLocation = idLocation;
    }

    public Long getLongitude() {

        return longitude;
    }

    public void setLongitude(Long longitude) {

        this.longitude = longitude;
    }

    public Long getLatitude() {

        return latitude;
    }

    public void setLatitude(Long latitude) {

        this.latitude = latitude;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public Integer getZipCode() {

        return zipCode;
    }

    public void setZipCode(Integer zipCode) {

        this.zipCode = zipCode;
    }
}
