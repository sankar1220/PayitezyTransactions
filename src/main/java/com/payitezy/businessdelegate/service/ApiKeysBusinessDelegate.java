package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.service.IApiKeysService;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiKeysBusinessDelegate implements IBusinessDelegate<ApiKeysModel, ApiKeysContext, IKeyBuilder<String>, String> {

    @Autowired
    private IApiKeysService apiKeysService;
    Logger LOGGER = Logger.getLogger(ApiKeysBusinessDelegate.class);

    @Override
    public ApiKeysModel create(final ApiKeysModel model) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ApiKeysContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public ApiKeysModel edit(final IKeyBuilder<String> keyBuilder, final ApiKeysModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiKeysModel getByKey(final IKeyBuilder<String> keyBuilder, final ApiKeysContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<ApiKeysModel> getCollection(final ApiKeysContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
