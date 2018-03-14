package com.revature.unavailableservice.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.unavailableservice.dao.ActivatableObjectRepository;
import com.revature.unavailableservice.domain.Activatable;

import java.io.Serializable;

/**
 * Created by August Duet on 11/29/2016.
 */
public class ActivatableObjectDaoService<T extends Activatable, ID extends Serializable> extends DaoService<T, ID>{


    protected ActivatableObjectRepository<T, ID> repo;

    @Autowired
    public void setRepo(ActivatableObjectRepository<T, ID> repo) {
        this.repo = repo;
    }

    @Override
    public void deleteItem(ID id){

        try{
            repo.delete(id);
        }catch(Exception ex){
        	Logger.getRootLogger().error(ex);
            Activatable item = repo.findOne(id);
            item.setActive(false);

            T saveItem = (T)item;
            repo.save(saveItem);
        }
    }
}
