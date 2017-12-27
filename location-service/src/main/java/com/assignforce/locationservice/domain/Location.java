package com.assignforce.locationservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@ApiModel("Location")
@Document(collection = "location")
public class Location implements Activatable {

    @Id
    @ApiModelProperty(notes = "The location ID", name = "ID", dataType = "ObjectId")
    private ObjectId ID;

    @ApiModelProperty(notes = "The location name", name = "name", dataType = "String")
    private String name;

    @ApiModelProperty(notes = "The location city", name = "city", dataType = "String")
    private String city;

    @ApiModelProperty(notes = "The location state", name = "state", dataType = "String")
    private String state;

    @ApiModelProperty(notes = "A boolean used to mark a location active or not", name = "active", dataType = "Boolean")
    private Boolean active;

    @ApiModelProperty(notes = "A list of buildings at the location", name = "buildings", dataType = "List<Building>")
    private List<Building> buildings;

    public Location() {
        //No arg constructor
    }

    public Location(ObjectId iD, String name, String city, String state, List<Building> buildings, Boolean active) {
        super();
        ID = iD;
        this.name = name;
        this.city = city;
        this.state = state;
        this.buildings = buildings;
        this.active = active;
    }

    public Location(String name, String city, String state, List<Building> buildings, Boolean active) {
        super();
        this.name = name;
        this.city = city;
        this.state = state;
        this.buildings = buildings;
        this.active = active;
    }

    public ObjectId getID() {
        return ID;
    }

    public void setID(ObjectId iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "Location [ID = " + ID + ", name = " + name + ", city = "
                + city + ", state = " + state + ", active = " + active
                + ", buildings = " + buildings + "]";
    }
}