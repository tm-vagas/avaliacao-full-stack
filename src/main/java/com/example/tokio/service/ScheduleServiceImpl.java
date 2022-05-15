package com.example.tokio.service;

import com.example.tokio.bo.FeeCalculatorBO;
import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.dto.ScheduleTransactionDTO;
import com.example.tokio.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleTransactionEntity scheduleTransactionEntity;
    ScheduleRepository scheduleRepository;

    private final ModelMapper mapper;

    public ScheduleServiceImpl(ModelMapper mapper) {

        this.mapper = mapper;
    }

    @Override
    public ScheduleTransactionEntity getSchedule(Long id) {
        return null;
    }

    @Override
    public ScheduleTransactionEntity createSchedule(ScheduleTransactionDTO entity) {
        return null;
    }

    @Override
    public ScheduleTransactionEntity updateSchedule(Long id) {
        return null;
    }

    @Override
    public ScheduleTransactionEntity deleteSchedule(Long id) {
        return null;
    }

//    @Override
//    public ScheduleTransactionEntity createSchedule(ScheduleTransactionDTO entity) {
//
//        scheduleTransactionEntity = mapper.map(entity, ScheduleTransactionEntity.class);
//
//        try {
//            scheduleTransactionEntity.setFee(FeeCalculatorBO.feeByAmount(entity.getDate(), entity.getSchedule(), entity.getAmount()));
//            return scheduleRepository.save(scheduleTransactionEntity);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public ScheduleTransactionEntity updateSchedule(Long id) {
//
//        try {
//            scheduleTransactionEntity = scheduleRepository.findById(id).get();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public ScheduleTransactionEntity deleteSchedule(ScheduleTransactionDTO entity) {
//
//        scheduleTransactionEntity = mapper.map(entity, ScheduleTransactionEntity.class);
//        return scheduleTransactionEntity;
//    }
}
