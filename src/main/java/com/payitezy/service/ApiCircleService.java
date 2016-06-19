package com.payitezy.service;

import com.payitezy.dao.ApiCircleRepository;
import com.payitezy.domain.ApiCircle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiCircleService implements IApiCircleService {

    @Autowired
    private ApiCircleRepository apiCircleRepository;

    @Override
    public ApiCircle create(final ApiCircle apiCircle) {
        // TODO Auto-generated method stub
        return apiCircleRepository.save(apiCircle);
    }

    @Override
    public void deleteApiDetails(final String apiCircleId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ApiCircle> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiCircle getApiCircle(final String apiCircleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiCircle getApiCircleByPayitEzyCircle(final String payitezyOperatorCircle, final String apiDetailsId) {
        // TODO Auto-generated method stub
        return apiCircleRepository.findApiCircleByPayitezyWithAPI(payitezyOperatorCircle, apiDetailsId);
    }

    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiCircle updateApiCircle(final ApiCircle apiCircle) {
        // TODO Auto-generated method stub
        return null;
    }

}
