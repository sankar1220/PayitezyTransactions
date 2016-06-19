package com.payitezy.model.converters;

import com.payitezy.domain.ClickTransaction;
import com.payitezy.model.ClickTransactionModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("clickTransactionToClickTransactionModelConverter")
public class ClickTransactionToClickTransactionModelConverter implements Converter<ClickTransaction, ClickTransactionModel> {
    @Autowired
    private ObjectFactory<ClickTransactionModel> clickTransactionModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ClickTransactionModel convert(final ClickTransaction source) {
        ClickTransactionModel clickTransactionModel = clickTransactionModelFactory.getObject();
        BeanUtils.copyProperties(source, clickTransactionModel);

        return clickTransactionModel;
    }

    @Autowired
    public void setClickTransactionModelFactory(final ObjectFactory<ClickTransactionModel> clickTransactionModelFactory) {
        this.clickTransactionModelFactory = clickTransactionModelFactory;
    }
}
