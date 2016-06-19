package com.payitezy.service;

import com.payitezy.domain.PayitezyOperator;

import java.util.List;

public interface IPayitezyOperatorService {
    PayitezyOperator create(PayitezyOperator payitezyOperator);

    void deletePayitezyOperator(String payitezyOperatorId);

    List<PayitezyOperator> getAll();

    Integer getMaxCode();

    List<PayitezyOperator> getOperatorByType(String operatorType);

    PayitezyOperator getPayitezyOperator(String payitezyOperatorId);

    PayitezyOperator getPayitezyOperatorByApiOperator(String operator);

    PayitezyOperator updatePayitezyOperator(PayitezyOperator payitezyOperator);
}
