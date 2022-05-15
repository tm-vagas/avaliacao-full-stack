package com.example.tokio.dto;


import javax.validation.constraints.NotNull;

public class ScheduleTransactionDTO {

    @NotNull
    private String from;
    @NotNull
    private String to;
    @NotNull
    private double amount;
    @NotNull
    private String date;
    @NotNull
    private String schedule;

    public String getFrom() {

        return from;
    }

    public void setFrom(String from) {

        this.from = from;
    }

    public String getTo() {

        return to;
    }

    public void setTo(String to) {

        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getSchedule() {

        return schedule;
    }

    public void setSchedule(String schedule) {

        this.schedule = schedule;
    }
}
