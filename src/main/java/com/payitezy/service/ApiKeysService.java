package com.payitezy.service;

import com.payitezy.dao.ApiKeysRepository;
import com.payitezy.domain.ApiKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiKeysService implements IApiKeysService {

    @Autowired
    private ApiKeysRepository apiKeysRepository;

    @Override
    public ApiKeys create(final ApiKeys apiKey) {
        // TODO Auto-generated method stub
        return apiKeysRepository.save(apiKey);
    }

}
