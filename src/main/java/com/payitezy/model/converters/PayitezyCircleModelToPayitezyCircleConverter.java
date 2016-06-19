package com.payitezy.model.converters;

import com.payitezy.domain.PayitezyCircle;
import com.payitezy.model.PayitezyCircleModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("payitezyCircleModelToPayitezyCircleConverter")
public class PayitezyCircleModelToPayitezyCircleConverter implements Converter<PayitezyCircleModel, PayitezyCircle> {
    @Autowired
    private ObjectFactory<PayitezyCircle> payitezyCircleFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PayitezyCircle convert(final PayitezyCircleModel source) {
        PayitezyCircle payitezyCircle = payitezyCircleFactory.getObject();
        BeanUtils.copyProperties(source, payitezyCircle);

        return payitezyCircle;
    }

    @Autowired
    public void setPayitezyCircleFactory(final ObjectFactory<PayitezyCircle> payitezyCircleFactory) {
        this.payitezyCircleFactory = payitezyCircleFactory;
    }

}