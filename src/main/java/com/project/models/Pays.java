package com.project.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pays")

public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int paysId;
    private int workerId;
    private LocalDate date;
    private double earnings;
    private double payments;

    private double saldo;
    private String description;

    public Pays() {}

    public int getPaysId() {
        return paysId;
    }

    public void setPaysId(int paysId) {
        this.paysId = paysId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSumSaldo(double earnings,double payments){
       double sum=0;
       sum+=(earnings-payments);
        return  sum;
    }
}
