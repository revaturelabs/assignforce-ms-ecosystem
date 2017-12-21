package com.revature.assignforcecurriculumms.domain.dao;

import com.revature.assignforcecurriculumms.domain.Curriculum;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends ActivatableObjectRepository<Curriculum, Integer> {

}
