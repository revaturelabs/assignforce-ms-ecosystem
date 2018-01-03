package com.revature.assignforcetrainerms.domain;

import java.util.List;

//import com.revature.assignforcetrainerms.domain.jsonpojos.Skill;
//import com.revature.assignforcetrainerms.domain.jsonpojos.Unavailable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Entity
//@Table(name = "TRAINER")
@Document(collection = "TRAINER")
public class Trainer implements Activatable{

	/*@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "trainerSeq", sequenceName = "TRAINER_SEQ")
	@GeneratedValue(generator = "trainerSeq", strategy = GenerationType.SEQUENCE)*/
	@Id
	private int trainerId;

//	@Column(name = "FIRST_NAME", nullable = false)
//	@Field("FIRST_NAME")
	private String firstName;
	
//	@Column(name = "LAST_NAME", nullable = false)
//	@Field("LAST_NAME")
	private String lastName;

//	@Column(name = "TRAINER_RESUME")
//	@Field("TRAINER_RESUME")

	private String resume;

/*	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="TRAINER_UNAVAILABILITY_JT", 
	joinColumns=@JoinColumn(name="TRAINER"), 
	inverseJoinColumns=@JoinColumn(name="UNAVAILABILITY"))
	private List<Unavailable> unavailabilities;*/
  
//	@ElementCollection
//	@CollectionTable(name = "TRAINER_UNAVAILABILITY_JT", joinColumns = @JoinColumn(name = "TRAINER"))
//	@Column(name = "UNAVAILABILITY")
//	private List<Integer> UnavailableList;

/*	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="TRAINER_SKILL_JT",
    joinColumns=@JoinColumn(name="TRAINER"),
    inverseJoinColumns=@JoinColumn(name="SKILL"))
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")						// ADDED this to fix serialization/infinite loop issues
	private List<Skill> skills;*/
  
//	@ElementCollection
//	@CollectionTable(name = "TRAINER_SKILL_JT", joinColumns = @JoinColumn(name = "TRAINER"))
//	@Column(name = "SKILL")
	private List<Integer> skills;

//	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="Trainer")
//	@Field
	private List<Certification> certifications;

//	@Column(name="active", insertable = false)
//	@Field
	private Boolean active;

	public Trainer(){
		//no-arg constructor
	}

	public Trainer(String firstName, String lastName, String resume, List<Integer> skills, List<Certification> certifications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
//		this.UnavailableList = unavailability;
		this.skills = skills;
		this.certifications = certifications;
		this.resume = resume;
		this.active = true;
	}

	public Trainer(int trainerId, String firstName, String lastName, String resume, List<Integer> skills, List<Certification> certifications) {
		super();
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.UnavailableList = unavailability;
		this.skills = skills;
		this.certifications = certifications;
		this.resume = resume;
		this.active = true;
	}

    public int getTrainerId() {
        return trainerId;
    }

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//
//	public List<Integer> getUnavailabilities() {
//		return UnavailableList;
//	}
//
//	public void setUnavailabilities(List<Integer> unavailabilities) {
//		this.UnavailableList = unavailabilities;
//	}
//
	public List<Integer> getSkills() {
		return skills;
	}

	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
}
