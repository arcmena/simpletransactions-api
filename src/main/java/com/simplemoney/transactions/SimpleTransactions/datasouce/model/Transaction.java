package com.simplemoney.transactions.SimpleTransactions.datasouce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private BigDecimal value;

    @Enumerated(value = EnumType.STRING)
    private TypeCardApplication cardApplication;

    @Enumerated(value = EnumType.STRING)
    private TypeStatus status ;


    public Transaction() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeCardApplication getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(TypeCardApplication cardApplication) {
        this.cardApplication = cardApplication;
    }

    public TypeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
