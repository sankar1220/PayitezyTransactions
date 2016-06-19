package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.domain.ClickTransaction;
import com.payitezy.model.ApiOperatorMarginModel;
import com.payitezy.model.ClickTransactionModel;

@Component("clickTransactionModelToClickTransactionConverter")
public class ClickTransactionModelToClickTransactionConverter implements Converter<ClickTransactionModel, ClickTransaction> {
    @Autowired
    private ObjectFactory<ClickTransaction> clickTransactionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ClickTransaction convert(final ClickTransactionModel source) {
    	ClickTransaction clickTransaction= clickTransactionFactory.getObject();
        BeanUtils.copyProperties(source, clickTransaction);

        return clickTransaction;
    }

    @Autowired
    public void setClickTransactionFactory(final ObjectFactory<ClickTransaction> clickTransactionFactory) {
        this.clickTransactionFactory = clickTransactionFactory;
    }

}
