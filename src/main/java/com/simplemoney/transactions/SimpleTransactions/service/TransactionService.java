package com.simplemoney.transactions.SimpleTransactions.service;

import com.simplemoney.transactions.SimpleTransactions.datasouce.model.Transaction;
import com.simplemoney.transactions.SimpleTransactions.exception.ResourceException;
import com.simplemoney.transactions.SimpleTransactions.repository.TransactionRepository;
import com.simplemoney.transactions.SimpleTransactions.resource.model.TransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionConversor transactionConversor;

    public Transaction createTransaction(TransactionResource transactionResource) throws ResourceException {
        try {
            Transaction transaction = transactionConversor.conversor(transactionResource);
            return transactionRepository.saveAndFlush(transaction);
        } catch (ResourceException e) {
            throw new ResourceException(e);
        }
    }

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getById(Long id) throws ResourceException {
        try {
            Optional<Transaction> data = transactionRepository.findById(id);
            if(!data.isPresent()) throw new ResourceException("Transaction not found with id " + id);
            return data;
        }catch (ResourceException e){
            throw new ResourceException(e);
        }
    }

    public Transaction updateTransaction(Long id, TransactionResource transactionResource) throws ResourceException {
        try{
            Optional<Transaction> record = transactionRepository.findById(id);
            if(!record.isPresent()) throw new ResourceException("Transaction not found with id " + id);

            Transaction data = record.get();
            Transaction updatedData = transactionConversor.conversor(transactionResource);

            data.setDate(updatedData.getDate());
            data.setTime(updatedData.getTime());
            data.setValue(updatedData.getValue());
            data.setCardApplication(updatedData.getCardApplication());
            data.setStatus(updatedData.getStatus());

            return transactionRepository.saveAndFlush(data);

        }catch (ResourceException e){
            throw new ResourceException(e);
        }
    }
}
