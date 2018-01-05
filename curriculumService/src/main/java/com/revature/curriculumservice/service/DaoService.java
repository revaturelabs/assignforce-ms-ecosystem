package com.revature.curriculumservice.service;

import com.revature.curriculumservice.domain.Activatable;
import com.revature.curriculumservice.domain.dao.ActivatableObjectRepository;
import com.revature.curriculumservice.domain.dao.BaseRepository;
import com.revature.curriculumservice.domain.dao.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class DaoService<T, ID extends Serializable>{

	@Autowired
	protected BaseRepository<T, ID> repo;

	public T saveItem(T persisted) { return repo.save(persisted); }

	public T getOneItem(ID id) {
		return repo.findOne(id);
	}

	public void deleteItem(ID id){
		repo.delete(id);
	}

	public List<T> getAllItems() {
		return (List<T>) repo.findAll();
	}
}
