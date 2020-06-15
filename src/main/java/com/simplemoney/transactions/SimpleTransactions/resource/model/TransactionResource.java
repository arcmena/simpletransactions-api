package com.simplemoney.transactions.SimpleTransactions.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResource {

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;

    @JsonProperty("value")
    private String value;

    @JsonProperty("cardApplication")
    private String cardApplication;

    @JsonProperty("status")
    private String status ;

    public TransactionResource(String date, String time, String value, String cardApplication, String status) {
        this.date = date;
        this.time = time;
        this.value = value;
        this.cardApplication = cardApplication;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(String cardApplication) {
        this.cardApplication = cardApplication;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionResource{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", value='" + value + '\'' +
                ", cardApplication='" + cardApplication + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
