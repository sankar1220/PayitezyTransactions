package com.payitezy.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.payitezy.domain.Address;
import com.payitezy.domain.ClickTransaction;

public interface ClickTransactionRepository extends PagingAndSortingRepository<ClickTransaction, Serializable> {

}
