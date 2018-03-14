package com.revature.assignforcebatchms.service;

import com.revature.assignforcebatchms.domain.BatchLocation;
import com.revature.assignforcebatchms.dao.BatchLocationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by August Duet on 4/7/2017.
 */
@Transactional
@Service
public class BatchLocationDaoService extends DaoService<BatchLocation, Integer>{
    @PersistenceContext
    EntityManager em;

    public BatchLocation refresh(BatchLocation bl){
        em.refresh(bl);
        return bl;
    }
}
