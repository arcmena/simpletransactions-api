package com.simplemoney.transactions.SimpleTransactions.repository;

import com.simplemoney.transactions.SimpleTransactions.datasouce.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository <Transaction, Long> { }
