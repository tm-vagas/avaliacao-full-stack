package com.example.tokio.controller;

import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.dto.ScheduleTransactionDTO;
import com.example.tokio.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transfer/schedule/")
public class HomeController {

    private final ScheduleService scheduleService;

    public HomeController(ScheduleService scheduleService) {

        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleTransactionEntity> createSchedule(@Valid @RequestBody ScheduleTransactionDTO scheduleTransactionDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.add(scheduleTransactionDto));
    }

    @GetMapping("/list")
    public List<ScheduleTransactionEntity> getAll() {

        return scheduleService.getAll();
    }

    /**
     * update schedule by id and return 204 status code.
     * @param id schedule id
     * @param scheduleTransactionDto schedule transaction dto
     * @return 201
     */
    @PostMapping("/update/{id}")
    public ResponseEntity<ScheduleTransactionEntity> getById(@Valid @RequestBody ScheduleTransactionDTO scheduleTransactionDto, @PathVariable(value = "id") long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.update(scheduleTransactionDto, id));
    }

    /**
     * delete schedule by id and return 204 status code.
     *
     * @param id schedule id
     * @return 204 status code
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity remove(@PathVariable(value = "id") long id) {

        scheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * get schedule by id and return 200 status code with schedule entity.
     *
     * @param id schedule id
     * @return 200 status code with schedule entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleTransactionEntity> getById(@PathVariable(value = "id") long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.getById(id));
    }
}
