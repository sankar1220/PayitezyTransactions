package com.payitezy.service;

import com.payitezy.domain.ApiCircle;

import java.util.List;

public interface IApiCircleService {
    ApiCircle create(ApiCircle apiCircle);

    void deleteApiDetails(String apiCircleId);

    List<ApiCircle> getAll();

    ApiCircle getApiCircle(String apiCircleId);

    ApiCircle getApiCircleByPayitEzyCircle(String payitezyOperatorCircle, String apiDetailsId);

    Integer getMaxCode();

    ApiCircle updateApiCircle(ApiCircle apiCircle);
}
