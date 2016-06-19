package com.payitezy.service;

import com.payitezy.dao.ApiOperatorMarginRepository;
import com.payitezy.domain.ApiOperatorMargin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperatorMarginService implements IApiOperatorMarginService {

    @Autowired
    private ApiOperatorMarginRepository apiOperatorMarginRepository;

    @Override
    public ApiOperatorMargin create(final ApiOperatorMargin apiOperatorMargin) {
        // TODO Auto-generated method stub
        return apiOperatorMarginRepository.save(apiOperatorMargin);
    }

    @Override
    public void deleteApiOperatorMargin(final String apiOperatorMarginId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ApiOperatorMargin> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiOperatorMargin getApiOperatorMargin(final String apiOperatorMarginId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ApiOperatorMargin> getApiOperatorSortByMargin(final String payitezyOperatorId) {
        // TODO Auto-generated method stub
        return apiOperatorMarginRepository.findOperatorsByPayitezyOperatorWithMaxMargin(payitezyOperatorId);
    }

    @Override
    public ApiOperatorMargin updateApiOperatorMargin(final ApiOperatorMargin apiOperatorMargin) {
        // TODO Auto-generated method stub
        return null;
    }

}
