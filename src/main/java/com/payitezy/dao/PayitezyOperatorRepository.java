package com.payitezy.dao;

import com.payitezy.domain.PayitezyOperator;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayitezyOperatorRepository extends PagingAndSortingRepository<PayitezyOperator, Serializable> {

    @Query("SELECT po FROM PayitezyOperator po JOIN po.apiOperatorMargins aom WHERE aom.apiOperatorId=?1")
    PayitezyOperator findOperatorByApiOperator(String operator);

    @Query("SELECT  MAX(p.payitezyOperatorCount) FROM PayitezyOperator p")
    Integer getMaxCode();

    @Query("SELECT po FROM PayitezyOperator po WHERE po.payitezyOperatorType = ?1")
    List<PayitezyOperator> getPayitezyOperatorByOperatorType(String operatorType);

}
