package com.revature.skillservice.service;

import com.revature.skillservice.domain.Skill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zach Nelson on 2/9/2017.
 */

@Transactional
@Service
public class SkillService extends ActivatableObjectDaoService<Skill, Integer>{
}
