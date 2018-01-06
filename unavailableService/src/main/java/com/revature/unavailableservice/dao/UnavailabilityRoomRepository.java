package com.revature.unavailableservice.dao;

import org.springframework.stereotype.Repository;
import com.revature.unavailableservice.domain.UnavailabilityRoom;

import java.util.List;

@Repository
public interface UnavailabilityRoomRepository extends BaseRepository<UnavailabilityRoom, Integer> {
    public List<UnavailabilityRoom> findByRoomId(Integer id);
}
