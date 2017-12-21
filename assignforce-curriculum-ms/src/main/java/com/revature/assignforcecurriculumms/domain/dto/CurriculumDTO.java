package com.revature.assignforcecurriculumms.domain.dto;

import com.revature.assignforcecurriculumms.domain.CurriculumSkillJT;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("Curriculum")
public class CurriculumDTO {

	@ApiModelProperty(notes = "The Curriculum ID", name = "currID", dataType = "int")
	private int currId;
	@ApiModelProperty(notes = "The Curriculum Name")
	private String name;
	@ApiModelProperty(notes = "A list of curriculum skills")
	private List<CurriculumSkillJT> skills;
	@ApiModelProperty(notes = "A boolean used to mark a curriculum active or not")
	private Boolean active;
	@ApiModelProperty(notes = "A boolean used to mark a curriculum core or not")
	private Boolean core;
	
	public int getCurrId() {
		return currId;
	}
	public void setCurrId(int currId) {
		this.currId = currId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<CurriculumSkillJT> getSkills() {
		return skills;
	}
	public void setSkills(List<CurriculumSkillJT> skills) {
		this.skills = skills;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getCore() {
		return core;
	}
	public void setCore(Boolean core) {
		this.core = core;
	}
}
