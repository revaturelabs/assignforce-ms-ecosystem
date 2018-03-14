package com.revature.assignforce.location.dao;

import com.revature.assignforce.location.model.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ActivatableObjectRepository<Location, Integer> {

}
