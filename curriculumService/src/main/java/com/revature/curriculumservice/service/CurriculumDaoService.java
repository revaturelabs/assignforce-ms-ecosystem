package com.revature.curriculumservice.service;

import com.revature.curriculumservice.domain.Curriculum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CurriculumDaoService extends ActivatableObjectDaoService<Curriculum, Integer> {

}
