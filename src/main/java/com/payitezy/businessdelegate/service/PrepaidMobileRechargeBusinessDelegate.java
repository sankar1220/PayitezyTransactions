package com.payitezy.businessdelegate.service;

import com.payitezy.apiobjects.PrepaidMobileRecharge;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.PrepaidMobileRechargeModel;
import com.payitezy.service.IPrepaidMobileRechargeService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PrepaidMobileRechargeBusinessDelegate implements
IBusinessDelegate<PrepaidMobileRechargeModel, PrepaidMobileRechargeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IPrepaidMobileRechargeService prepaidMobileRechargeService;

    @Override
    public PrepaidMobileRechargeModel create(final PrepaidMobileRechargeModel model) {

        PrepaidMobileRecharge prepaidMobileRecharge = new PrepaidMobileRecharge();
        prepaidMobileRecharge.setAmount(model.getAmount());
        prepaidMobileRecharge.setNumber(model.getNumber());
        prepaidMobileRecharge.setCircle(model.getCircle());
        prepaidMobileRecharge.setOperator(model.getOperator());
        prepaidMobileRecharge = prepaidMobileRechargeService.rechargePrepaidMobile(prepaidMobileRecharge);

        PrepaidMobileRechargeModel prepaidMobileRechargeModel = conversionService.convert(prepaidMobileRecharge,
                PrepaidMobileRechargeModel.class);

        return prepaidMobileRechargeModel;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargeContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public PrepaidMobileRechargeModel edit(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargeModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrepaidMobileRechargeModel getByKey(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargeContext context) {

        return null;
    }

    @Override
    public Collection<PrepaidMobileRechargeModel> getCollection(final PrepaidMobileRechargeContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
