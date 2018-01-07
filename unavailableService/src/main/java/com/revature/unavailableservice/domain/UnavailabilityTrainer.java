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
@Table(name = "UNAVAILABILITY_TRAINER")
public class UnavailabilityTrainer {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "unavailableSeq", sequenceName = "UNAVAILABLE_TRAINER_SEQ")
	@GeneratedValue(generator = "unavailableSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "TRAINERID", nullable=false)
	private String trainerId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE", nullable=false)
	private Timestamp startDate;


	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE", nullable=false)
	private Timestamp endDate;

	
	public UnavailabilityTrainer(){
		//noarg constructor
	}

	
	public UnavailabilityTrainer(int id, String trainerId, Timestamp startDate, Timestamp endDate) {
		super();
		this.id = id;
		this.trainerId = trainerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
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
		return "Unavailabilities_Trainers [ID=" + id + ", trainerId=" + trainerId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	
}
