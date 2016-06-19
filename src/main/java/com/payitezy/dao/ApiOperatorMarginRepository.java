package com.payitezy.dao;

import com.payitezy.domain.ApiOperatorMargin;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiOperatorMarginRepository extends PagingAndSortingRepository<ApiOperatorMargin, Serializable> {

    @Query("SELECT aom FROM ApiOperatorMargin aom JOIN aom.payitezyOperator po JOIN aom.apiDetails ad WHERE po.id=?1 ORDER BY aom.margin DESC")
    List<ApiOperatorMargin> findOperatorsByPayitezyOperatorWithMaxMargin(String payitezyOperatorId);

}
