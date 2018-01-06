package com.revature.unavailableservice.dao;

import org.springframework.stereotype.Repository;
import com.revature.unavailableservice.domain.UnavailabilityTrainer;

import java.util.List;

@Repository
public interface UnavailabilityTrainerRepository extends BaseRepository<UnavailabilityTrainer, String> {
    public List<UnavailabilityTrainer> findByTrainerId(String trainerId);
    public void deleteById(Integer id);
}
