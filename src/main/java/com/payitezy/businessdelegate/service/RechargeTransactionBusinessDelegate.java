package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.RechargeTransactionModel;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class RechargeTransactionBusinessDelegate implements
IBusinessDelegate<RechargeTransactionModel, RechargeTransactionContext, IKeyBuilder<String>, String> {
    {

    }

    @Override
    public RechargeTransactionModel create(final RechargeTransactionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final RechargeTransactionContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public RechargeTransactionModel edit(final IKeyBuilder<String> keyBuilder, final RechargeTransactionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RechargeTransactionModel getByKey(final IKeyBuilder<String> keyBuilder, final RechargeTransactionContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<RechargeTransactionModel> getCollection(final RechargeTransactionContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}