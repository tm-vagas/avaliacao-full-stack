package com.example.tokio.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String from;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String to;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private double amount;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String date;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String schedule;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private double fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "id=" + id +
            ", from='" + from + '\'' +
            ", to='" + to + '\'' +
            ", amount=" + amount +
            ", date='" + date + '\'' +
            ", schedule='" + schedule + '\'' +
            ", fee=" + fee +
            '}';
    }
}
