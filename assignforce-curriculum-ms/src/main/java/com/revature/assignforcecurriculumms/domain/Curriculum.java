package com.revature.assignforcecurriculumms.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CURRICULUM")
public class Curriculum implements Activatable{

	private int currId;
	private String name;
	private List<CurriculumSkillJT> skills;
	private Boolean active;
	private Boolean core;
	
	public Curriculum(){
		//noarg constructor
	}

	public Curriculum(int currId, String name, List<CurriculumSkillJT> skills, boolean core) {
		super();
		this.currId = currId;
		this.name = name;
		this.skills = skills;
		this.core=core;
	}

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "curriculumSeq", sequenceName = "CURRICULUM_SEQ")
	@GeneratedValue(generator = "curriculumSeq", strategy = GenerationType.SEQUENCE)
	public int getCurrId() {
		return currId;
	}
	public void setCurrId(int currId) {
		this.currId = currId;
	}

	@Column(name = "NAME", unique=true, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CURRICULUM_SKILL_JT", joinColumns = {@JoinColumn(name = "CURRICULUM_ID")})
	//@JoinColumn(name = "CURRICULUM_ID")
	public List<CurriculumSkillJT> getSkills() { return skills; }
	public void setSkills(List<CurriculumSkillJT> skills) {
		this.skills = skills;
	}

	@Column(name="ACTIVE", insertable = false)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name="CORE")
	public Boolean getCore() {
		return core;
	}
	public void setCore(Boolean core) {
		this.core = core;
	}

	@Override
	public String toString() {
		return "Curriculum [ID = " + currId + ", name = " + name + ", skills = " + skills + "]";
	}
}
