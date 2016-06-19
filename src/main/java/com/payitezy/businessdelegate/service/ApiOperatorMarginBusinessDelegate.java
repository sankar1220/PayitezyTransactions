package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.ApiDetails;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.domain.PayitezyOperator;
import com.payitezy.model.ApiOperatorMarginModel;
import com.payitezy.service.IApiOperatorMarginService;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiOperatorMarginBusinessDelegate implements
        IBusinessDelegate<ApiOperatorMarginModel, ApiOperatorMarginContext, IKeyBuilder<String>, String> {

    Logger LOGGER = Logger.getLogger(ApiOperatorMarginBusinessDelegate.class);

    @Autowired
    private IApiOperatorMarginService apiOperatorMarginService;

    @Override
    public ApiOperatorMarginModel create(final ApiOperatorMarginModel model) {

        ApiOperatorMargin aom = new ApiOperatorMargin();
        aom.setMargin(Double.parseDouble(model.getMargin()));
        aom.setMobileOperatorCheck(model.getMobileOperatorCheck());
        aom.setCreatedDate(new Date());
        aom.setRechargesStatus(model.getRechargesStatus());
        aom.setStatus(model.getStatus());
        aom.setApiOperatorId(model.getApiOperatorId());
        PayitezyOperator po = new PayitezyOperator();
        po.setId(model.getPayitezyOperatorId());
        aom.setPayitezyOperator(po);
        ApiDetails ad = new ApiDetails();
        ad.setId(model.getApiDetailsId());
        aom.setApiDetails(ad);
        aom = apiOperatorMarginService.create(aom);
        model.setId(aom.getId());
        // TODO Auto-generated method stub
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ApiOperatorMarginContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public ApiOperatorMarginModel edit(final IKeyBuilder<String> keyBuilder, final ApiOperatorMarginModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiOperatorMarginModel getByKey(final IKeyBuilder<String> keyBuilder, final ApiOperatorMarginContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<ApiOperatorMarginModel> getCollection(final ApiOperatorMarginContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
