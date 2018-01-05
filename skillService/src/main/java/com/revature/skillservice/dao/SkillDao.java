package com.revature.skillservice.dao;

import org.springframework.stereotype.Repository;

import com.revature.skillservice.domain.Skill;

@Repository
public interface SkillDao extends ActivatableObjectRepository<Skill, Integer> {

}
