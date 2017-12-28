package com.revature.assignforcebatchms.domain;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.*;

//import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BATCH"
//,uniqueConstraints = {
	//	@UniqueConstraint(columnNames = "BATCH_LOCATION")
//}
)
public class Batch {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "batchSeq", sequenceName = "BATCH_SEQ")
	@GeneratedValue(generator = "batchSeq", strategy = GenerationType.SEQUENCE)
	private int ID;

	@Column(name = "NAME")
	private String name;

	@Column(name = "START_DATE", nullable = false)
	private Timestamp startDate;

	@Column(name = "END_DATE", nullable = false)
	private Timestamp endDate;

	@Column(name = "CURRICULUM")
	private Integer curriculum;
	
	@Column(name = "FOCUS")
	private Integer focus;

	@ManyToOne
	@JoinColumn(name = "STATUS")
	@Fetch(FetchMode.JOIN)
	private BatchStatusLookup batchStatus;

	@Column(name = "TRAINER")
	private Integer trainer;

	@Column(name = "COTRAINER")
	private Integer cotrainer;

	@OneToOne
	@JoinColumn(name = "BATCH_LOCATION")
	BatchLocation batchLocation;
	
	@ElementCollection                                                          
	@CollectionTable(name = "BATCH_SKILL_JT", joinColumns = @JoinColumn(name = "BATCH_ID"))
	@Column(name = "SKILL_ID")                                                    
	private List<Integer> skills;

	public Batch() {
		// noarg constructor
	}

	public Batch(int iD, String name, Timestamp startDate, Timestamp endDate, Integer curriculum,
			BatchStatusLookup batchStatus, Integer trainer, Integer coTrainer, List<Integer> skills,
			Integer focus, BatchLocation batchLocation
		) {
		super();
		ID = iD;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.curriculum = curriculum;
		this.batchStatus = batchStatus;
		this.trainer = trainer;
		this.cotrainer = coTrainer;
		this.skills = skills;
		this.focus = focus;
		this.batchLocation = batchLocation;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Integer curriculum) {
		this.curriculum = curriculum;
	}

	public Integer getFocus() {
		return focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

	public BatchStatusLookup getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(BatchStatusLookup batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Integer getTrainer() {
		return trainer;
	}

	public void setTrainer(Integer trainer) {
		this.trainer = trainer;
	}

	public Integer getCotrainer() {
		return cotrainer;
	}

	public void setCotrainer(Integer cotrainer) {
		this.cotrainer = cotrainer;
	}

	public BatchLocation getBatchLocation() {
		return batchLocation;
	}

	public void setBatchLocation(BatchLocation batchLocation) {
		this.batchLocation = batchLocation;
	}

	public List<Integer> getSkills() {
		return skills;
	}

	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}
}
