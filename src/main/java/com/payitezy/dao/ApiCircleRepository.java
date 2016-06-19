package com.payitezy.dao;

import com.payitezy.domain.ApiCircle;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiCircleRepository extends PagingAndSortingRepository<ApiCircle, Serializable> {

    @Query("SELECT ac FROM ApiCircle ac JOIN ac.payitezyCircle pc JOIN ac.apiDetails ad WHERE pc.id=?1 AND ad.id=?2")
    ApiCircle findApiCircleByPayitezyWithAPI(String payitezyOperatorCircle, String apiDetailsId);

}
