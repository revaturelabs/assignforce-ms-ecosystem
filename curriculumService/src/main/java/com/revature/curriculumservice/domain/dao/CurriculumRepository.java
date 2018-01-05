package com.revature.curriculumservice.domain.dao;

import com.revature.curriculumservice.domain.Curriculum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumRepository extends ActivatableObjectRepository<Curriculum, Integer> {

    List<Curriculum> findByActiveIsTrueAndCoreIsTrue();

    List<Curriculum> findByActiveIsTrueAndCoreIsFalse();

    List<Curriculum> findByCoreIsTrue();

    List<Curriculum> findByCoreIsFalse();
}
