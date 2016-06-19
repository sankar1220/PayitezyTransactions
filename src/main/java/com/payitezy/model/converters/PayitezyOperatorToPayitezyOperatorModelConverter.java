package com.payitezy.model.converters;

import com.payitezy.domain.PayitezyOperator;
import com.payitezy.model.ApiOperatorMarginModel;
import com.payitezy.model.PayitezyOperatorModel;
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

@Component("payitezyOperatorToPayitezyOperatorModelConverter")
public class PayitezyOperatorToPayitezyOperatorModelConverter implements Converter<PayitezyOperator, PayitezyOperatorModel> {
    @Autowired
    private ObjectFactory<PayitezyOperatorModel> payitezyOperatorModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PayitezyOperatorModel convert(final PayitezyOperator source) {
        PayitezyOperatorModel payitezyOperatorModel = payitezyOperatorModelFactory.getObject();
        BeanUtils.copyProperties(source, payitezyOperatorModel);

        if (CollectionUtils.isNotEmpty(source.getApiOperatorMargins())) {
            List<ApiOperatorMarginModel> converted = (List<ApiOperatorMarginModel>) conversionService.convert(
                    source.getApiOperatorMargins(), TypeDescriptor.forObject(source.getApiOperatorMargins()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiOperatorMarginModel.class));
            payitezyOperatorModel.getApiOperatorMarginModels().addAll(converted);
        }
        return payitezyOperatorModel;
    }

    @Autowired
    public void setPayitezyOperatorModelFactory(final ObjectFactory<PayitezyOperatorModel> payitezyOperatorModelFactory) {
        this.payitezyOperatorModelFactory = payitezyOperatorModelFactory;
    }

}
