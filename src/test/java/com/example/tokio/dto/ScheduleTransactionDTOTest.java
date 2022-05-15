package com.example.tokio.dto;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTransactionDTOTest {

    ScheduleTransactionDTO scheduleTransactionDto;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        scheduleTransactionDto = new ScheduleTransactionDTO();
    }

    @org.junit.jupiter.api.Test
    void transactionTest() {

        scheduleTransactionDto.setAmount(1000);
        scheduleTransactionDto.setDate("2020-05-10 15:00:00.000");
        scheduleTransactionDto.setSchedule("2020-05-20 15:00:00.000");
        scheduleTransactionDto.setFrom("056923");
        scheduleTransactionDto.setTo("095184");

        assertEquals(1000.0, scheduleTransactionDto.getAmount());
    }
}