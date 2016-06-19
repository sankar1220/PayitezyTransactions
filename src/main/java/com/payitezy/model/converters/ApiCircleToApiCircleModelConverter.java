package com.payitezy.model.converters;

import com.payitezy.domain.ApiCircle;
import com.payitezy.model.ApiCircleModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("apiCircleToApiCircleModelConverter")
public class ApiCircleToApiCircleModelConverter implements Converter<ApiCircle, ApiCircleModel> {
    @Autowired
    private ObjectFactory<ApiCircleModel> apiCircleModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiCircleModel convert(final ApiCircle source) {
        ApiCircleModel apiCircleModel = apiCircleModelFactory.getObject();
        BeanUtils.copyProperties(source, apiCircleModel);

        return apiCircleModel;
    }

    @Autowired
    public void setApiDetailsModelFactory(final ObjectFactory<ApiCircleModel> apiCircleModelFactory) {
        this.apiCircleModelFactory = apiCircleModelFactory;
    }
}
