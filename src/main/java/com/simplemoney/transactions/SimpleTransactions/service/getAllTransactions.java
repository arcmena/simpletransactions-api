package com.simplemoney.transactions.SimpleTransactions.service;

import com.simplemoney.transactions.SimpleTransactions.datasouce.model.Transaction;
import com.simplemoney.transactions.SimpleTransactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class getAllTransactions {
    @Autowired
    private TransactionRepository transactionRepository;

    public void create(Transaction transaction){
        transactionRepository.saveAndFlush(transaction);
    }

//    public void findById(){
//        Optional<Transaction> findById = transactionRepository.findById(1L);
//        Transaction transaction = findById.get();
//    }
}
