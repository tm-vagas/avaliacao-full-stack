package com.example.tokio.controller;

import com.example.tokio.dto.ScheduleTransactionDTO;
import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.mock.ScheduleTransactionMock;
import com.example.tokio.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transfer/")
public class HomeController {

    private final ScheduleService scheduleRepository;

    public HomeController(ScheduleService scheduleRepository) {

        this.scheduleRepository = scheduleRepository;
    }

//    @PostMapping(value = "/schedule")
//    public ResponseEntity<ScheduleTransactionEntity> createSchedule(@Valid @RequestBody ScheduleTransactionDTO scheduleTransactionDto) {
//
//        ScheduleTransactionEntity scheduleTransactionEntity = scheduleRepository.createSchedule(scheduleTransactionDto);
//        return ResponseEntity.status(201).body(scheduleTransactionEntity);
//    }
//
//    @PutMapping(value = "/schedule/{id}")
//    public ResponseEntity<ScheduleTransactionEntity> updateSchedule(@PathVariable("id") Long id) {
//
//        ScheduleTransactionEntity scheduleTransactionEntity = scheduleRepository.updateSchedule(id);
//        return ResponseEntity.status(200).body(scheduleTransactionEntity);
//    }
//
//    @GetMapping(value = "/scheduleMock", produces = "application/json")
//    public List<ScheduleTransactionEntity> scheduleMock() {
//
//        ScheduleTransactionMock scheduleTransactionMock = new ScheduleTransactionMock();
//        return scheduleTransactionMock.fakeScheduleTransactions(100);
//    }
}
