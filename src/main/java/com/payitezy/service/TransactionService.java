package com.payitezy.service;

import com.payitezy.domain.Transaction;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TransactionService implements ITransactionService {

    @Override
    public Transaction findByTransaction(final String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Transaction> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return null;
    }

}
