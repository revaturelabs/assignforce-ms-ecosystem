package com.revature.skillms.dao;

import org.springframework.stereotype.Repository;

import com.revature.skillms.domain.Skill;

@Repository
public interface SkillDao extends ActivatableObjectRepository<Skill, Integer> {

}
