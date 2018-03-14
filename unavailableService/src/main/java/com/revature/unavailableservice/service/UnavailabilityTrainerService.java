package com.revature.unavailableservice.service;

import com.revature.unavailableservice.dao.UnavailabilityTrainerRepository;
import com.revature.unavailableservice.domain.UnavailabilityTrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UnavailabilityTrainerService extends DaoService<UnavailabilityTrainer, String>{
    @Autowired
    private  UnavailabilityTrainerRepository repo;

    public List<UnavailabilityTrainer> findByTrainerId(String id) {
        return repo.findByTrainerId(id);
    }

    public void deleteItem(Integer id) {
        repo.deleteById(id);
    }
}
