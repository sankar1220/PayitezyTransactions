package com.payitezy.businessdelegate.service;

import com.payitezy.DBSequences;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.ApiDetails;
import com.payitezy.domain.ApiKeys;
import com.payitezy.model.ApiDetailsModel;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.service.IApiDetailsService;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiDetailsBusinessDelegate implements IBusinessDelegate<ApiDetailsModel, ApiDetailsContext, IKeyBuilder<String>, String> {

    Logger LOGGER = Logger.getLogger(ApiDetailsBusinessDelegate.class);

    @Autowired
    private IApiDetailsService apiDetailsService;

    @Override
    public ApiDetailsModel create(final ApiDetailsModel model) {
        // TODO Auto-generated method stub

        ApiDetails apiDetails = new ApiDetails();

        apiDetails.setApiName(model.getApiName());
        apiDetails.setCreatedDate(new Date());
        apiDetails.setStatus(model.getStatus());
        Integer i = apiDetailsService.getMaxCode();
        if (i == null || i == 0) {
            i = 0;
            apiDetails.setApiCount(i + 1);
        }
        else {
            apiDetails.setApiCount(i + 1);
        }
        Integer co = i + 1;
        String m = DBSequences.APIDETAILS.getSequenceName();
        String mc = m.concat(co.toString());
        apiDetails.setApiCode(mc);

        Set<ApiKeys> apiKeys = new HashSet<ApiKeys>();
        if (model.getApiKeyModels() != null) {
            for (ApiKeysModel apiKeyModel : model.getApiKeyModels()) {
                ApiKeys apiKey = new ApiKeys();
                apiKey.setKeyName(apiKeyModel.getKeyName());
                apiKey.setKeyValue(apiKeyModel.getKeyValue());
                apiKey.setStatus(apiKeyModel.getStatus());
                apiKey.setCreatedDate(new Date());
                apiKey.setApiDetails(apiDetails);
                apiKeys.add(apiKey);
            }
            apiDetails.setApiKeyses(apiKeys);
        }

        apiDetails = apiDetailsService.create(apiDetails);
        model.setId(apiDetails.getId());
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ApiDetailsContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public ApiDetailsModel edit(final IKeyBuilder<String> keyBuilder, final ApiDetailsModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiDetailsModel getByKey(final IKeyBuilder<String> keyBuilder, final ApiDetailsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<ApiDetailsModel> getCollection(final ApiDetailsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
