package com.example.tokio.dao;


import com.example.tokio.bo.FeeCalculatorBO;

public class ScheduleTransactionEntity {
    private String from;
    private String to;
    private double amount;
    private String date;
    private String schedule;
    private String status;
    private String type;
    private double fee;
    private int days;

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

    public double getFee() {

        return fee;
    }

    public void setFee(double fee) {

        this.fee = fee;
    }

    public int getDays() {

        return days;
    }

    public void setDays(int days) {

        this.days = days;
    }

    @Override
    public String toString() {
        return "ScheduleTransactionEntity{" +
            "from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", amount=" + amount +
            ", date='" + date + '\'' +
            ", schedule='" + schedule + '\'' +
            ", status='" + status + '\'' +
            ", type='" + type + '\'' +
            ", fee=" + fee +
            ", days=" + days +
            '}';
    }
}
