package com.example.tokio.mock;

import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.dto.ScheduleTransactionDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTransactionMockTest {

    ScheduleTransactionMock scheduleTransactionMock = new ScheduleTransactionMock();

    @org.junit.jupiter.api.Test
    void testScheduleTransaction() {
        List<ScheduleTransactionEntity> schedules = scheduleTransactionMock.fakeScheduleTransactions(100);
        assertEquals(100, schedules.size());
    }

    @Test
    void fakeAccount() {
        String account = scheduleTransactionMock.fakeAccount();
        assertEquals(6, account.length());
    }

    @Test
    void fakeAmount() {
        double amount = scheduleTransactionMock.fakeAmount();
        assertTrue(amount > 0);
    }

    @Test
    void fakeDate() {
        String date = scheduleTransactionMock.fakeDate();
        assertEquals(23, date.length());
    }
}