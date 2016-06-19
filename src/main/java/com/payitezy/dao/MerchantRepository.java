package com.payitezy.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.payitezy.domain.Address;
import com.payitezy.domain.Merchant;

public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Serializable> {

}
