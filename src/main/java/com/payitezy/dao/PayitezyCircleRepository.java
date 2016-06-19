package com.payitezy.dao;

import com.payitezy.domain.PayitezyCircle;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayitezyCircleRepository extends PagingAndSortingRepository<PayitezyCircle, Serializable> {

    @Query("SELECT pc FROM PayitezyCircle pc JOIN pc.apiCircles ac WHERE ac.apiCircleCode=?1")
    PayitezyCircle findPayitezyCircleByApiCircle(String circle);

}
