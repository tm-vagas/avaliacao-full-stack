package com.example.tokio.repository;

import com.example.tokio.model.ScheduleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleModel, Long> {}
