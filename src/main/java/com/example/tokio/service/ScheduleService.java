package com.example.tokio.service;

import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.dto.ScheduleTransactionDTO;
import com.example.tokio.repository.ScheduleRepository;

public interface ScheduleService {
    ScheduleTransactionEntity getSchedule(Long id);
    ScheduleTransactionEntity createSchedule(ScheduleTransactionDTO entity);
    ScheduleTransactionEntity updateSchedule(Long id);
    ScheduleTransactionEntity deleteSchedule(Long id);
}
