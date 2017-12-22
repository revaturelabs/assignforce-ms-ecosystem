package com.revature.unavailableservice.dao;

import org.springframework.stereotype.Repository;


import com.revature.unavailableservice.domain.Unavailable;

@Repository
public interface UnavailableRepository extends BaseRepository<Unavailable, Integer> {

}
