package com.payitezy.businessdelegate.service;

import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.MobileOperatorModel;
import com.payitezy.service.IMobileOperatorService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class MobileOperatorBusinessDelegate implements
IBusinessDelegate<MobileOperatorModel, MobileOperatorContext, IKeyBuilder<String>, String> {

    @Autowired
    private IMobileOperatorService mobileOperatorService;
    @Autowired
    private ConversionService conversionService;

    @Override
    public MobileOperatorModel create(final MobileOperatorModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final MobileOperatorContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public MobileOperatorModel edit(final IKeyBuilder<String> keyBuilder, final MobileOperatorModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MobileOperatorModel getByKey(final IKeyBuilder<String> keyBuilder, final MobileOperatorContext context) {
        String mobileNumber = keyBuilder.build().toString();
        MobileOperator mobileOperator = mobileOperatorService.getMobileOperatorCircleByMobileNumber(mobileNumber);
        MobileOperatorModel model = conversionService.convert(mobileOperator, MobileOperatorModel.class);

        return model;
    }

    @Override
    public Collection<MobileOperatorModel> getCollection(final MobileOperatorContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
