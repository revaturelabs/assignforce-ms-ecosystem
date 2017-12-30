package com.assignforce.locationmicroservice.service;

import com.assignforce.locationmicroservice.domain.dao.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class DaoService<T, ID extends Serializable>{

	@Autowired
	protected BaseRepository<T, ID> repo;

	//    @HystrixCommand(fallbackMethod = "reliable")
	public T saveItem(T persisted) {
		return repo.save(persisted);
	}

	//    @HystrixCommand(fallbackMethod = "reliable")
	public T getOneItem(ID id) {
		return repo.findOne(id);
	}

	//    @HystrixCommand(fallbackMethod = "reliable")
	public void deleteItem(ID id){
		repo.delete(id);
	}

	//    @HystrixCommand(fallbackMethod = "reliable")
	@Transactional
	public List<T> getAllItems() {
		return (List<T>) repo.findAll();
	}

	public String reliable() {
		return "Hystrix fallback";
	}
}