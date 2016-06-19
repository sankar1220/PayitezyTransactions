package com.payitezy.dao;

import com.payitezy.domain.Address;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Serializable> {

}
