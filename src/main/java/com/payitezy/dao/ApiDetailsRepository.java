package com.payitezy.dao;

import com.payitezy.domain.ApiDetails;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiDetailsRepository extends PagingAndSortingRepository<ApiDetails, Serializable> {

    @Query("SELECT MAX(a.apiCount) FROM ApiDetails a")
    Integer getMaxCode();

}
