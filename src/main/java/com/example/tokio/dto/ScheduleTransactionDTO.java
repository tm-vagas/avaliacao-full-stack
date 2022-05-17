package com.example.tokio.dto;


import javax.validation.constraints.NotNull;

public class ScheduleTransactionDTO {

    @NotNull
    private String sender;
    @NotNull
    private String receiver;
    @NotNull
    private double amount;
    @NotNull
    private String date;
    @NotNull
    private String schedule;

    @NotNull
    private String status;

    @NotNull
    private String type;

    public String getSender() {

        return sender;
    }

    public void setSender(String sender) {

        this.sender = sender;
    }

    public String getReceiver() {

        return receiver;
    }

    public void setReceiver(String receiver) {

        this.receiver = receiver;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
