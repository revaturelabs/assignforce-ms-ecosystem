package com.revature.unavailableservice.service;

import com.revature.unavailableservice.dao.UnavailabilityRoomRepository;
import com.revature.unavailableservice.domain.UnavailabilityRoom;
import com.revature.unavailableservice.domain.Unavailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nick Edwards on 3/2/2017.
 */

@Transactional
@Service
public class UnavailabilityRoomService extends DaoService<UnavailabilityRoom, Integer>{
    @Autowired
    UnavailabilityRoomRepository roomRepo;

    public List<UnavailabilityRoom> findByRoomId(Integer id) {
        return roomRepo.findByRoomId(id);
    }
}
