package com.assignforce.locationservice.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ApiModel("Building")
@Document(collection = "location")
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Building implements Activatable {

//    private int ID;

    @ApiModelProperty(notes = "The name of the building", name = "name", dataType = "String")
    private String name;

//    private int location;

    @ApiModelProperty(notes = "A boolean used to mark a building active or not", name = "active", dataType = "Boolean")
    private Boolean active;

    @ApiModelProperty(notes = "A list of Rooms in the building", name = "rooms", dataType = "List<room>")
    private List<Room> rooms;

    public Building() {
        //No arg constructor
    }

    public Building(int ID, String name, List<Room> rooms, boolean active, int location) {
        super();
//        this.ID = ID;
        this.name = name;
        this.rooms = rooms;
//        this.location = location;
        this.active = active;
    }

//    public Building(int location) {
//        this.location = location;
//    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int iD) {
//        ID = iD;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getLocation() {
//        return location;
//    }
//
//    public void setLocation(int location) {
//        this.location = location;
//    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", active=" + active +
                ", rooms=" + rooms +
                '}';
    }
}