package com.payitezy.service;

import com.payitezy.dao.PayitezyOperatorRepository;
import com.payitezy.domain.PayitezyOperator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayitezyOperatorService implements IPayitezyOperatorService {

    @Autowired
    private PayitezyOperatorRepository payitezyOperatorRepository;

    @Override
    public PayitezyOperator create(final PayitezyOperator payitezyOperator) {
        // TODO Auto-generated method stub
        return payitezyOperatorRepository.save(payitezyOperator);
    }

    @Override
    public void deletePayitezyOperator(final String payitezyOperatorId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PayitezyOperator> getAll() {
        // TODO Auto-generated method stub
        return (List<PayitezyOperator>) payitezyOperatorRepository.findAll();
    }

    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub

        Integer c = payitezyOperatorRepository.getMaxCode();
        return c;
    }

    @Override
    public List<PayitezyOperator> getOperatorByType(final String operatorType) {
        // TODO Auto-generated method stub
        return payitezyOperatorRepository.getPayitezyOperatorByOperatorType(operatorType);
    }

    @Override
    public PayitezyOperator getPayitezyOperator(final String payitezyOperatorId) {
        // TODO Auto-generated method stub
        return payitezyOperatorRepository.findOne(payitezyOperatorId);
    }

    @Override
    public PayitezyOperator getPayitezyOperatorByApiOperator(final String operator) {
        // TODO Auto-generated method stub
        return payitezyOperatorRepository.findOperatorByApiOperator(operator);
    }

    @Override
    public PayitezyOperator updatePayitezyOperator(final PayitezyOperator payitezyOperator) {
        // TODO Auto-generated method stub
        return null;
    }

}
