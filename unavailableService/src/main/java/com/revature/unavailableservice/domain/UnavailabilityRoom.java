package com.revature.unavailableservice.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UNAVAILABILITY_ROOM")
public class UnavailabilityRoom {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "unavailableSeq", sequenceName = "UNAVAILABLE_SEQ")
	@GeneratedValue(generator = "unavailableSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "ROOMID", nullable=false)
	private int roomId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE", nullable=false)
	private Timestamp startDate;


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE", nullable=false)
	private Timestamp endDate;

	
	public UnavailabilityRoom(){
		//noarg constructor
	}
	
	public UnavailabilityRoom(int id, int roomId, Timestamp startDate, Timestamp endDate) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		Id = Id;
	}
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Unavailabilities_Rooms [ID=" + id + ", roomId=" + roomId + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
}
