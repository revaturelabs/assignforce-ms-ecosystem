package com.revature.assignforcetrainerms.domain.jsonpojos;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;

import com.revature.assignforcetrainerms.domain.Activatable;


public class Skill implements Activatable{

	private int skillId;
	
	private String name;

	private Boolean active;

	public Skill(){
		//noarg constructor
	}
	
	public Skill(int skillId, String name) {
		super();
		this.skillId = skillId;
		this.name = name;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Skill [ID = " + skillId + ", Name = " + name + "]";
	}
}
