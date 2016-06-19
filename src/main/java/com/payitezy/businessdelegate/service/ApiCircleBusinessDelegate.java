package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.ApiCircle;
import com.payitezy.domain.ApiDetails;
import com.payitezy.domain.PayitezyCircle;
import com.payitezy.model.ApiCircleModel;
import com.payitezy.service.IApiCircleService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ApiCircleBusinessDelegate implements IBusinessDelegate<ApiCircleModel, ApiCircleContext, IKeyBuilder<String>, String> {

    @Autowired
    private IApiCircleService apiCircleService;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiCircleModel create(final ApiCircleModel model) {
        // TODO Auto-generated method stub

        ApiCircle apiCircle = new ApiCircle();
        apiCircle.setStatus(model.getStatus());
        apiCircle.setApiCircleCode(model.getApiCircleCode());
        ApiDetails apiDetails = new ApiDetails();
        apiDetails.setId(model.getApiDetailsId());
        apiCircle.setApiDetails(apiDetails);
        PayitezyCircle payitezyCircle = new PayitezyCircle();
        payitezyCircle.setId(model.getPayitezyCircleId());
        apiCircle.setPayitezyCircle(payitezyCircle);
        apiCircle = apiCircleService.create(apiCircle);
        if (apiCircle.getId() != null) {
            model.setId(apiCircle.getId());
        }
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ApiCircleContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public ApiCircleModel edit(final IKeyBuilder<String> keyBuilder, final ApiCircleModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiCircleModel getByKey(final IKeyBuilder<String> keyBuilder, final ApiCircleContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<ApiCircleModel> getCollection(final ApiCircleContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
