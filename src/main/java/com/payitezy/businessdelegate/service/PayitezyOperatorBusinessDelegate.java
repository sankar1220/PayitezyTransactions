package com.payitezy.businessdelegate.service;

import com.payitezy.DBSequences;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.PayitezyOperator;
import com.payitezy.model.PayitezyOperatorModel;
import com.payitezy.service.IPayitezyOperatorService;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PayitezyOperatorBusinessDelegate implements
        IBusinessDelegate<PayitezyOperatorModel, PayitezyOperatorContext, IKeyBuilder<String>, String> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IPayitezyOperatorService payitezyOperatorService;
    Logger LOGGER = Logger.getLogger(PayitezyOperatorBusinessDelegate.class);

    @Override
    public PayitezyOperatorModel create(final PayitezyOperatorModel model) {
        PayitezyOperator payitezyOperator = new PayitezyOperator();

        payitezyOperator.setPayitezyOperatorName(model.getPayitezyOperatorName());
        payitezyOperator.setPayitezyOperatorType(model.getPayitezyOperatorType());
        payitezyOperator.setStatus(model.getStatus());
        payitezyOperator.setCreatedDate(new Date());

        Integer i = payitezyOperatorService.getMaxCode();
        if (i == null || i == 0) {
            i = 1;

            payitezyOperator.setPayitezyOperatorCount(i);
        }
        else {
            payitezyOperator.setPayitezyOperatorCount(i + 1);

        }

        Integer co = i + 1;
        String m = DBSequences.PAYOPER.getSequenceName();
        String mc = m.concat(co.toString());
        payitezyOperator.setPayitezyOperatorCode(mc);

        payitezyOperator = payitezyOperatorService.create(payitezyOperator);
        // TODO Auto-generated method stub
        if (payitezyOperator.getId() != null) {
            model.setId(payitezyOperator.getId());
            model.setPayitezyOperatorCode(payitezyOperator.getPayitezyOperatorCode());

        }
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PayitezyOperatorContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public PayitezyOperatorModel edit(final IKeyBuilder<String> keyBuilder, final PayitezyOperatorModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PayitezyOperatorModel getByKey(final IKeyBuilder<String> keyBuilder, final PayitezyOperatorContext context) {
        // TODO Auto-generated method stub
        PayitezyOperator payitezyOperator = payitezyOperatorService.getPayitezyOperator(keyBuilder.build().toString());

        PayitezyOperatorModel model = conversionService.convert(payitezyOperator, PayitezyOperatorModel.class);

        return model;
    }

    @Override
    public Collection<PayitezyOperatorModel> getCollection(final PayitezyOperatorContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
