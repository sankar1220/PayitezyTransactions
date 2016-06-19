package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.domain.PayitezyCircle;
import com.payitezy.model.PayitezyCircleModel;
import com.payitezy.service.IPayitezyCircleService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author Mohan
 *
 */
@Service
public class PayitezyCircleBusinessDelegate implements
        IBusinessDelegate<PayitezyCircleModel, PayitezyCircleContext, IKeyBuilder<String>, String> {

    Logger LOGGER = Logger.getLogger(PayitezyCircleBusinessDelegate.class);

    @Autowired
    private IPayitezyCircleService payitezyCircleService;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PayitezyCircleModel create(final PayitezyCircleModel model) {

        PayitezyCircle pc = new PayitezyCircle();
        pc.setCircleName(model.getCircleName());
        pc.setDescription(model.getDescription());
        pc.setStatus(model.getStatus());
        pc = payitezyCircleService.create(pc);
        model.setId(pc.getId());

        // TODO Auto-generated method stub
        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PayitezyCircleContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public PayitezyCircleModel edit(final IKeyBuilder<String> keyBuilder, final PayitezyCircleModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PayitezyCircleModel getByKey(final IKeyBuilder<String> keyBuilder, final PayitezyCircleContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<PayitezyCircleModel> getCollection(final PayitezyCircleContext context) {
        List<PayitezyCircle> payitezyCircle = new ArrayList<PayitezyCircle>();
        List<PayitezyCircleModel> payitezyCircleModels = (List<PayitezyCircleModel>) conversionService.convert(payitezyCircle,
                TypeDescriptor.forObject(payitezyCircle),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PayitezyCircleModel.class)));
        return payitezyCircleModels;

        // TODO Auto-generated method stub

    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        conversionService = conversionService;
    }
}
