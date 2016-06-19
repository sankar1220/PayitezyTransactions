package com.payitezy.model.converters;

import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.model.ApiOperatorMarginModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("apiOperatorMarginToApiOperatorMarginModelConverter")
public class ApiOperatorMarginToApiOperatorMarginModelConverter implements Converter<ApiOperatorMargin, ApiOperatorMarginModel> {
    @Autowired
    private ObjectFactory<ApiOperatorMarginModel> apiOperatorMarginModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiOperatorMarginModel convert(final ApiOperatorMargin source) {
        ApiOperatorMarginModel apiOperatorMarginModel = apiOperatorMarginModelFactory.getObject();
        BeanUtils.copyProperties(source, apiOperatorMarginModel);

        return apiOperatorMarginModel;
    }

    @Autowired
    public void setApiOperatorMarginModelFactory(final ObjectFactory<ApiOperatorMarginModel> apiOperatorMarginModelFactory) {
        this.apiOperatorMarginModelFactory = apiOperatorMarginModelFactory;
    }
}
