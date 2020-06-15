package com.simplemoney.transactions.SimpleTransactions.controller;

import com.simplemoney.transactions.SimpleTransactions.datasouce.model.Transaction;
import com.simplemoney.transactions.SimpleTransactions.exception.ResourceException;
import com.simplemoney.transactions.SimpleTransactions.resource.model.TransactionResource;
import com.simplemoney.transactions.SimpleTransactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(path = "/{id}")
    public Object getById(@PathVariable(name = "id", required = true)Long id) throws ResourceException {
        try {
            return transactionService.getById(id);
        }catch (ResourceException e){
            return new ResponseEntity(e.getLocalizedMessage().toCharArray(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/all")
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @PostMapping(path = "/")
    public ResponseEntity<Transaction> create(@RequestBody TransactionResource transaction) throws ResourceException {
       try {
           return ResponseEntity.ok(transactionService.createTransaction(transaction));
       }catch (ResourceException e){
           return new ResponseEntity(e.getLocalizedMessage().toCharArray(), HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Transaction> update(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody TransactionResource transactionResource) throws ResourceException {
        try{
            return ResponseEntity.ok(transactionService.updateTransaction(id, transactionResource));
        }catch (ResourceException e){
            return new ResponseEntity(e.getLocalizedMessage().toCharArray(), HttpStatus.NOT_FOUND);
        }
    }
}
