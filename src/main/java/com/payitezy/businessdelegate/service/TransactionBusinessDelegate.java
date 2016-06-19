package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.Merchant;
import com.payitezy.domain.Transaction;
import com.payitezy.domain.Users;
import com.payitezy.model.TransactionModel;
import com.payitezy.service.IMerchantService;
import com.payitezy.service.IUsersService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:mail.properties")
//@ImportResource("classpath:spring-beans.xml")
public class TransactionBusinessDelegate implements IBusinessDelegate<TransactionModel, TransactionContext, IKeyBuilder<String>, String> {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IMerchantService merchantService;

    @Override
    public TransactionModel create(final TransactionModel model) {

        Transaction transaction = new Transaction();
        transaction.setUr(model.getUr());
        transaction.setTransacttionFor(model.getTransacttionFor());
        transaction.setAmount(Double.parseDouble(model.getAmount()));
        transaction.setCashbackAmount(Double.parseDouble(model.getCashbackAmount()));
        transaction.setRefundStatus(model.getRefundStatus());
        Users users = new Users();
        users.setId(model.getUsersId());
        transaction.setUsers(users);
        Merchant merchant = new Merchant();
        merchant.setId(model.getMerchant());
        transaction.setMerchant(merchant);
        // transaction = transactionService.create(transaction);
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final TransactionContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public TransactionModel edit(final IKeyBuilder<String> keyBuilder, final TransactionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TransactionModel getByKey(final IKeyBuilder<String> keyBuilder, final TransactionContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<TransactionModel> getCollection(final TransactionContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
