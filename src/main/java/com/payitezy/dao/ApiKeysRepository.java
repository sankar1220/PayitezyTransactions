package com.payitezy.dao;

import com.payitezy.domain.ApiKeys;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiKeysRepository extends PagingAndSortingRepository<ApiKeys, Serializable> {

}
