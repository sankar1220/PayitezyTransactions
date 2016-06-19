package com.payitezy.service;

import com.payitezy.domain.ApiDetails;

import java.util.List;

public interface IApiDetailsService {

    ApiDetails create(ApiDetails apiDetails);

    void deleteApiDetails(String apiDetailsId);

    List<ApiDetails> getAll();

    ApiDetails getApiDetails(String apiDetailsId);

    Integer getMaxCode();

    ApiDetails updateApiDetails(ApiDetails apiDetails);
}
