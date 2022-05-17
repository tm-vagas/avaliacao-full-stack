package com.example.tokio.model;

import javax.persistence.*;

@Entity
@Table(name = "scheduleTransfer")
public class ScheduleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 6)
    private String sender;

    @Column(nullable = false, length = 6)
    private String receiver;

    @Column(nullable = false, length = 60)
    private double amount;

    @Column(nullable = false, length = 30)
    private String date;

    @Column(nullable = false, length = 30)
    private String schedule;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false, length = 30)
    private String type;

    @Column(nullable = false, length = 10)
    private double fee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String from) {
        this.sender = from;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String to) {
        this.receiver = to;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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

    @Override
    public String toString() {
        return "ScheduleModel{" +
            "id=" + id +
            ", sender='" + sender + '\'' +
            ", receiver='" + receiver + '\'' +
            ", amount=" + amount +
            ", date='" + date + '\'' +
            ", schedule='" + schedule + '\'' +
            ", fee=" + fee +
            ", status='" + status + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
