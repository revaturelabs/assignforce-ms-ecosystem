package com.revature.curriculumservice.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "CURRICULUM_SKILL_JT")
public class CurriculumSkillJT {
    private CurrSkillPK currSkillPK;


    @EmbeddedId
    public CurrSkillPK getCurrSkillPK() {
        return currSkillPK;
    }

    public void setCurrSkillPK(CurrSkillPK currSkillPK) {
        this.currSkillPK = currSkillPK;
    }
}
