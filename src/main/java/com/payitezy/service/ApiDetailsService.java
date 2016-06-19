package com.payitezy.service;

import com.payitezy.dao.ApiDetailsRepository;
import com.payitezy.domain.ApiDetails;
import com.payitezy.domain.ApiKeys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiDetailsService implements IApiDetailsService {

    @Autowired
    private ApiDetailsRepository apiDetailsRepository;
    @Autowired
    private IApiKeysService apiKeysService;

    @Override
    public ApiDetails create(final ApiDetails apiDetails) {
        // TODO Auto-generated method stub
        ApiDetails apiDetail = apiDetailsRepository.save(apiDetails);
        if (apiDetails.getApiKeyses() != null) {
            Set<ApiKeys> apiKeys = new HashSet<ApiKeys>();
            for (ApiKeys apiKy : apiDetails.getApiKeyses()) {
                ApiKeys apiKey = apiKy;
                apiKey.setApiDetails(apiDetail);
                apiKey = apiKeysService.create(apiKey);
                apiKeys.add(apiKey);
            }
            apiDetail.setApiKeyses(apiKeys);
        }

        return apiDetail;
    }

    @Override
    public void deleteApiDetails(final String apiDetailsId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ApiDetails> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiDetails getApiDetails(final String apiDetailsId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getMaxCode() {
        Integer i = apiDetailsRepository.getMaxCode();
        // TODO Auto-generated method stub
        return i;
    }

    @Override
    public ApiDetails updateApiDetails(final ApiDetails apiDetails) {
        // TODO Auto-generated method stub
        return null;
    }

}
