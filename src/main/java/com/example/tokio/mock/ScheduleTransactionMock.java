package com.example.tokio.mock;

import com.example.tokio.dao.ScheduleTransactionEntity;
import com.example.tokio.util.Util;

import java.util.List;

public class ScheduleTransactionMock {

    public String fakeAccount() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(Util.randomNumber(1));
        }
        return sb.toString();
    }

    public double fakeAmount() {

        return round(Util.randomNumber(4) + Util.randomNumber(4) / 100.0);
    }

    public double round(double value) {

        return Math.round(value * 100.0) / 100.0;
    }

    //TODO: change to real date
    public String fakeDate() {

        return Util.convertTime(System.currentTimeMillis());
    }

    public String increaseDaysBy(int days, String date) {

        return date.substring(0, date.length() - 2) + (Integer.parseInt(date.substring(date.length() - 2)) + days);
    }

    public List<ScheduleTransactionEntity> fakeScheduleTransactions(int count) {

        List<ScheduleTransactionEntity> scheduleTransactions = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            scheduleTransactions.add(fakeScheduleTransaction());
        }
        return scheduleTransactions;
    }

    public ScheduleTransactionEntity fakeScheduleTransaction() {

        long timestamp = System.currentTimeMillis();
        int days = Util.randomNumber(2);
        String fakeDate = Util.convertTime(timestamp);
        long daysToSeconds = timestamp + Util.daysToSeconds(days);
        String fakeDateInFuture = Util.convertTime(daysToSeconds);
        ScheduleTransactionEntity scheduleTransaction = new ScheduleTransactionEntity();
        scheduleTransaction.setAmount(fakeAmount());
        scheduleTransaction.setDate(fakeDate);
        scheduleTransaction.setSchedule(fakeDateInFuture);
        scheduleTransaction.setSender(fakeAccount());
        scheduleTransaction.setReceiver(fakeAccount());
        scheduleTransaction.setStatus("pending");
        scheduleTransaction.setType("fake");
        return scheduleTransaction;
    }
}
