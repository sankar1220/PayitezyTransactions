package com.payitezy.model.converters;

import com.payitezy.domain.ApiKeys;
import com.payitezy.model.ApiKeysModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("apiKeysToApiKeysModelConverter")
public class ApiKeysToApiKeysModelConverter implements Converter<ApiKeys, ApiKeysModel> {
    @Autowired
    private ObjectFactory<ApiKeysModel> apiKeysModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiKeysModel convert(final ApiKeys source) {
        ApiKeysModel apiKeysModel = apiKeysModelFactory.getObject();
        BeanUtils.copyProperties(source, apiKeysModel);

        return apiKeysModel;
    }

    @Autowired
    public void setApiKeysModelFactory(final ObjectFactory<ApiKeysModel> apiKeysModelFactory) {
        this.apiKeysModelFactory = apiKeysModelFactory;
    }
}
