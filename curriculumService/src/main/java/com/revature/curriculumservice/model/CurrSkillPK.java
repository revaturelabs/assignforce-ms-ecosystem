package com.revature.curriculumservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CurrSkillPK implements Serializable {
    protected int currId;
    protected int skillId;

    public CurrSkillPK(){}

    public CurrSkillPK(int currId, int skillId) {
        this.currId = currId;
        this.skillId = skillId;
    }

    @Column(name = "CURRICULUM_ID")
    public int getCurrId() {
        return currId;
    }

    public void setCurrId(int currId) {
        this.currId = currId;
    }

    @Column(name = "SKILL_ID")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrSkillPK that = (CurrSkillPK) o;

        if (getCurrId() != that.getCurrId()) return false;
        return getSkillId() == that.getSkillId();
    }

    @Override
    public int hashCode() {
        int result = getCurrId();
        result = 31 * result + getSkillId();
        return result;
    }
}
