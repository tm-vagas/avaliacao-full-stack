package com.example.tokio.service;

import com.example.tokio.bo.FeeCalculatorBO;
import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.dto.ScheduleTransactionDTO;
import com.example.tokio.model.ScheduleModel;
import com.example.tokio.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ModelMapper modelMapper;

    public ScheduleService(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {

        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * add schedule transaction using schedule transaction dto.
     *
     * @param scheduleTransactionDTO schedule transaction dto
     * @return ScheduleTransactionEntity
     */
    @Transactional
    public ScheduleTransactionEntity add(ScheduleTransactionDTO scheduleTransactionDTO) {

        ScheduleModel scheduleModel = modelMapper.map(scheduleTransactionDTO, ScheduleModel.class);

        try {
            double fee = FeeCalculatorBO.feeByAmount(scheduleModel.getDate(), scheduleModel.getSchedule(), scheduleModel.getAmount());
            scheduleModel.setFee(fee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scheduleModel = scheduleRepository.save(scheduleModel);
        return modelMapper.map(scheduleModel, ScheduleTransactionEntity.class);
    }

    /**
     * update schedule transaction by id and schedule transaction dto.
     *
     * @param scheduleTransactionDTO schedule transaction dto
     * @param id schedule transaction id
     * @return ScheduleTransactionEntity
     */
    public ScheduleTransactionEntity update(ScheduleTransactionDTO scheduleTransactionDTO, Long id) {

        ScheduleModel scheduleModel = modelMapper.map(scheduleTransactionDTO, ScheduleModel.class);

        double fee = 0;

        try {
            fee = FeeCalculatorBO.feeByAmount(scheduleModel.getDate(), scheduleModel.getSchedule(), scheduleModel.getAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }

        double finalFee = fee;
        ScheduleModel finalScheduleModel = scheduleModel;
        scheduleModel = scheduleRepository.findById(id).map(schedule -> {
            schedule.setSchedule(finalScheduleModel.getSchedule());
            schedule.setAmount(finalScheduleModel.getAmount());
            schedule.setDate(finalScheduleModel.getDate());
            schedule.setSender(finalScheduleModel.getSender());
            schedule.setReceiver(finalScheduleModel.getReceiver());
            schedule.setFee(finalFee);
            schedule.setStatus(finalScheduleModel.getStatus());
            schedule.setType(finalScheduleModel.getType());

            return scheduleRepository.save(schedule);
        }).orElseGet(() -> {
            finalScheduleModel.setId(id);
            return scheduleRepository.save(finalScheduleModel);
        });

        return modelMapper.map(scheduleModel, (Type) ScheduleTransactionEntity.class);
    }

    /**
     * list all schedule transaction and return list of ScheduleTransactionEnties.
     *
     * @return List<ScheduleTransactionEntity>
     */
    public List<ScheduleTransactionEntity> getAll() {

        List<ScheduleTransactionEntity> scheduleTransactionEntities = new ArrayList<>();
        scheduleRepository.findAll().forEach(schedule -> {
            ScheduleTransactionEntity scheduleTransactionEntity = new ScheduleTransactionEntity();
            scheduleTransactionEntity.setId(schedule.getId());
            scheduleTransactionEntity.setSchedule(schedule.getSchedule());
            scheduleTransactionEntity.setAmount(schedule.getAmount());
            scheduleTransactionEntity.setDate(schedule.getDate());
            scheduleTransactionEntity.setSender(schedule.getSender());
            scheduleTransactionEntity.setReceiver(schedule.getReceiver());
            scheduleTransactionEntity.setFee(schedule.getFee());
            scheduleTransactionEntity.setStatus(schedule.getStatus());
            scheduleTransactionEntity.setType(schedule.getType());
            scheduleTransactionEntities.add(scheduleTransactionEntity);
        });

        return scheduleTransactionEntities;
    }

    /**
     * get schedule by id and return scheduleTransactionEntity.
     *
     * @param id schedule id
     * @return scheduleTransactionEntity
     */
    public ScheduleTransactionEntity getById(Long id) {

        ScheduleTransactionEntity scheduleTransactionEntity = new ScheduleTransactionEntity();
        scheduleRepository.findById(id).ifPresent(schedule -> {
            scheduleTransactionEntity.setId(schedule.getId());
            scheduleTransactionEntity.setSchedule(schedule.getSchedule());
            scheduleTransactionEntity.setAmount(schedule.getAmount());
            scheduleTransactionEntity.setDate(schedule.getDate());
            scheduleTransactionEntity.setSender(schedule.getSender());
            scheduleTransactionEntity.setReceiver(schedule.getReceiver());
            scheduleTransactionEntity.setFee(schedule.getFee());
            scheduleTransactionEntity.setStatus(schedule.getStatus());
            scheduleTransactionEntity.setType(schedule.getType());
        });

        return scheduleTransactionEntity;
    }

    /**
     * delete schedule transaction by id.
     *
     * @param id schedule transaction id
     */
    public void delete(Long id) {

        scheduleRepository.deleteById(id);
    }
}
