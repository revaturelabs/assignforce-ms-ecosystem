package com.revature.assignforce.location.services;

import java.io.Serializable;
import java.util.List;

import com.revature.assignforce.location.dao.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DaoService<T, ID extends Serializable>{

    @Autowired
    protected BaseRepository<T, ID> repo;

    public T saveItem(T persisted) {
        return repo.save(persisted);
    }

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
