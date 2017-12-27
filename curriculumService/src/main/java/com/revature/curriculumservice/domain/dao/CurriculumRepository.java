package com.revature.curriculumservice.domain.dao;

import com.revature.curriculumservice.domain.Curriculum;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends ActivatableObjectRepository<Curriculum, Integer> {

}
