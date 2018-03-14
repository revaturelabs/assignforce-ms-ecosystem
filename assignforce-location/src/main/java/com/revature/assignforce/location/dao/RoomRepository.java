package com.revature.assignforce.location.dao;

import com.revature.assignforce.location.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ActivatableObjectRepository<Room, Integer> {

}
