package com.payitezy.service;

import com.payitezy.domain.ApiOperatorMargin;

import java.util.List;

public interface IApiOperatorMarginService {
    ApiOperatorMargin create(ApiOperatorMargin apiOperatorMargin);

    void deleteApiOperatorMargin(String apiOperatorMarginId);

    List<ApiOperatorMargin> getAll();

    ApiOperatorMargin getApiOperatorMargin(String apiOperatorMarginId);

    List<ApiOperatorMargin> getApiOperatorSortByMargin(String payitezyOperatorId);

    ApiOperatorMargin updateApiOperatorMargin(ApiOperatorMargin apiOperatorMargin);
}
