package com.revature.skillservice.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    List<T> findAllByOrderByNameAsc();
    List<T> findAllByOrderBySkillIdAsc();
}
