package com.revature.assignforcebatchms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.assignforcebatchms.domain.Batch;

@Transactional
@Service
public class BatchDaoService extends DaoService<Batch, Integer> {
}
