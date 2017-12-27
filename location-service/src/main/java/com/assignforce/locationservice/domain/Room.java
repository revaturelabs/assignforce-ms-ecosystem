package com.assignforce.locationservice.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Room")
public class Room implements Activatable {

//    private int roomID;

    @ApiModelProperty(notes = "The room name", name = "roomName", dataType = "String")
    private String roomName;

//    private int building;

    @ApiModelProperty(notes = "A list of unavailabilities", name = "unavailabilities", dataType = "List<Unavailable>")
    private List<Unavailable> unavailabilities;

    @ApiModelProperty(notes = "A boolean that marks the room active or not", name = "active", dataType = "boolean")
    private Boolean active;

    public Room() {
        //No arg constructor
    }

    public Room(int roomID, String roomName, int building, List<Unavailable> unavailabilities) {
        super();
//        this.roomID = roomID;
        this.roomName = roomName;
//        this.building = building;
        this.unavailabilities = unavailabilities;
    }

    public Room(int roomID, String roomName, int building, List<Unavailable> unavailabilities, Boolean active) {
        super();
//        this.roomID = roomID;
        this.roomName = roomName;
//        this.building = building;
        this.unavailabilities = unavailabilities;
        this.active = active;
    }

//    public Room(int buildingID){
//        this.building = buildingID;
//    }
//
//    public int getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(int building) {
//        this.building = building;
//    }
//
//    public int getRoomID() {
//        return roomID;
//    }
//    public void setRoomID(int roomID) {
//        this.roomID = roomID;
//    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Unavailable> getUnavailabilities() {
        return unavailabilities;
    }
    public void setUnavailabilities(List<Unavailable> unavailabilities) {
        this.unavailabilities = unavailabilities;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", unavailabilities=" + unavailabilities +
                ", active=" + active +
                '}';
    }
}
