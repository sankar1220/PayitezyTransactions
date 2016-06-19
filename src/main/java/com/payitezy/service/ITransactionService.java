package com.payitezy.service;

import com.payitezy.domain.Transaction;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ITransactionService {

    Transaction findByTransaction(String id);

    List<Transaction> getAll();

    Integer getMaxCode();

}
