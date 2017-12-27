package com.revature.assignforcetrainerms.domain.jsonpojos;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Unavailable {	

	private int ID;

	private Timestamp startDate;
	
	private Timestamp endDate;

	
	public Unavailable(){
		//noarg constructor
	}

	public Unavailable(Timestamp startDate, Timestamp endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Unavailable(int id, Timestamp startDate, Timestamp endDate) {
		super();
		this.ID = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
		return "Unavailable [ID = " + ID + ", startDate = " + startDate + ", endDate = " + endDate + "]";
	}	
}
