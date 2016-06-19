package com.payitezy.model.converters;

import com.payitezy.domain.PayitezyCircle;
import com.payitezy.model.ApiCircleModel;
import com.payitezy.model.PayitezyCircleModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("payitezyCircleToPayitezyCircleModelConverter")
public class PayitezyCircleToPayitezyCircleModelConverter implements Converter<PayitezyCircle, PayitezyCircleModel> {
    @Autowired
    private ObjectFactory<PayitezyCircleModel> payitezyCircleModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PayitezyCircleModel convert(final PayitezyCircle source) {
        PayitezyCircleModel payitezyCircleModel = payitezyCircleModelFactory.getObject();
        BeanUtils.copyProperties(source, payitezyCircleModel);
        if (CollectionUtils.isNotEmpty(source.getApiCircles())) {
            List<ApiCircleModel> converted = (List<ApiCircleModel>) conversionService.convert(source.getApiCircles(),
                    TypeDescriptor.forObject(source.getApiCircles()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiCircleModel.class));
            payitezyCircleModel.getApiCircleModels().addAll(converted);
        }
        return payitezyCircleModel;
    }

    @Autowired
    public void setPayitezyCircleModelFactory(final ObjectFactory<PayitezyCircleModel> payitezyCircleModelFactory) {
        this.payitezyCircleModelFactory = payitezyCircleModelFactory;
    }

}