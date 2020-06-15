package com.simplemoney.transactions.SimpleTransactions.service;

import com.simplemoney.transactions.SimpleTransactions.datasouce.model.Transaction;
import com.simplemoney.transactions.SimpleTransactions.datasouce.model.TypeCardApplication;
import com.simplemoney.transactions.SimpleTransactions.datasouce.model.TypeStatus;
import com.simplemoney.transactions.SimpleTransactions.exception.ResourceException;
import com.simplemoney.transactions.SimpleTransactions.resource.model.TransactionResource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class TransactionConversor {

    public Transaction conversor(TransactionResource transactionResource) throws ResourceException {
        try{
            LocalDate date = checkDate(transactionResource.getDate());
            LocalTime time = checkTime(transactionResource.getTime());
            BigDecimal value = checkValue(transactionResource.getValue());
            TypeCardApplication cardApplication = checkCardApplication(transactionResource.getCardApplication());
            TypeStatus status = checkStatus(transactionResource.getStatus());

            return setTransaction(date, time, value, cardApplication, status);
        }catch (Exception e){
            throw new ResourceException(e);
        }
    }

    private Transaction setTransaction(LocalDate date, LocalTime time, BigDecimal value, TypeCardApplication cardApplication, TypeStatus status){
        Transaction transaction = new Transaction();

        transaction.setDate(date);
        transaction.setTime(time);
        transaction.setValue(value);
        transaction.setCardApplication(cardApplication);
        transaction.setStatus(status);

        return transaction;
    }

    private LocalDate checkDate(String date){
        return LocalDate.parse(date);
    }

    private LocalTime checkTime(String time){
        return LocalTime.parse(time);
    }

    private BigDecimal checkValue(String value){
        return new BigDecimal(value);
    }

    private TypeCardApplication checkCardApplication(String transactionType) throws ResourceException {
        switch (transactionType) {
            case "CREDITO":
                return TypeCardApplication.CREDITO;
            case "DEBITO":
                return TypeCardApplication.DEBITO;
            case "VOUCHER":
                return TypeCardApplication.VOUCHER;
            default:
                throw new ResourceException("CardApplication type not found");
        }
    }

    private TypeStatus checkStatus(String status) throws ResourceException {
        switch (status){
            case "SUCCESS":
                return TypeStatus.SUCCESS;
            case "PENDING":
                return TypeStatus.PENDING;
            case "CANCELED":
                return TypeStatus.CANCELED;
            case "FAILED":
                return TypeStatus.FAILED;
            default:
                throw new ResourceException("Status type not found");
        }
    }

}
