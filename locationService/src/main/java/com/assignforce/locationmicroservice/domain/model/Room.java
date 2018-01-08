package com.assignforce.locationmicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROOM")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Activatable {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "roomSeq", sequenceName = "ROOM_SEQ")
	@GeneratedValue(generator = "roomSeq", strategy = GenerationType.SEQUENCE)
	private int roomID;

	@Column(name = "NAME", nullable = false)
	private String roomName;
	
	//it is a one to one relationship, but we only need an id here..  Right?
	@Column(name="BUILDING")
	private int building;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//	@JoinTable(name = "ROOM_UNAVAILABILITY_JT",
//		joinColumns = @JoinColumn(name = "ROOM_ID"),
//		inverseJoinColumns = @JoinColumn(name = "UNAVAILABLE_ID"))
//	//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//	private List<Unavailable> unavailabilities;

//	@ElementCollection
//	@CollectionTable(name = "ROOM_UNAVAILABILITY_JT", joinColumns = @JoinColumn(name = "ROOM_ID"))
//	@Column(name = "UNAVAILABILITY")
//	private List<Integer> unavailableList;

	@Column(name = "active", insertable = false)
	private boolean active;

	public Room() {
		//No arg constructor
	}

	public Room(int roomID, String roomName, int building/*, List<Unavailable> unavailabilities*/) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.building = building;
//		this.unavailabilities = unavailabilities;
	}
	
	public Room(int roomID, String roomName, int building, /*List<Unavailable> unavailabilities,*/ boolean active) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.building = building;
//		this.unavailabilities = unavailabilities;
		this.active = active;
	}

	public Room(int buildingID){
		this.building = buildingID;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

//	public List<Unavailable> getUnavailabilities() {
//		return unavailabilities;
//	}
//	public void setUnavailabilities(List<Unavailable> unavailabilities) {
//		this.unavailabilities = unavailabilities;
//	}

	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Room [roomID = " + roomID + ", roomName = " + roomName + ", building = " + building + ", active = " + active + "]";
	}
}