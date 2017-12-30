package com.assignforce.locationmicroservice.domain.dao;

import com.assignforce.locationmicroservice.domain.model.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ActivatableObjectRepository<Location, Integer> {

}
