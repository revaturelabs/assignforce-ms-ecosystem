package com.revature.assignforcecurriculumms.service;

import com.revature.assignforcecurriculumms.domain.Curriculum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CurriculumDaoService extends ActivatableObjectDaoService<Curriculum, Integer> {

}
