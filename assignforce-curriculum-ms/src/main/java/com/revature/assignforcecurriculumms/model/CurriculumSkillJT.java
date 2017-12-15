package com.revature.assignforcecurriculumms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "CURRICULUM_SKILL_JT")
public class CurriculumSkillJT {
    private int currId;
    private int skillId;

    @Column(name = "CURRICULUM_ID")
    public int getCurrId() { return currId; }

    public void setCurrId(int currId) { this.currId = currId; }

    @Column(name = "SKILL_ID")
    public int getSkillId() { return skillId; }

    public void setSkillId(int skillId) { this.skillId = skillId; }
}
