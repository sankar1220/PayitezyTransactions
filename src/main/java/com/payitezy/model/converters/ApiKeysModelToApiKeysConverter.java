package com.payitezy.model.converters;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.domain.Address;
import com.payitezy.domain.ApiKeys;
import com.payitezy.domain.UserAddress;
import com.payitezy.model.AddressModel;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.util.CollectionTypeDescriptor;

@Component("apiKeysModelToApiKeysConverter")
public class ApiKeysModelToApiKeysConverter implements Converter<ApiKeysModel, ApiKeys> {
    @Autowired
    private ObjectFactory<ApiKeys> apiKeysFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiKeys convert(final ApiKeysModel source) {
    	ApiKeys apiKeys= apiKeysFactory.getObject();
        BeanUtils.copyProperties(source, apiKeys);

       

        return apiKeys;
    }

    @Autowired
    public void setApiKeysFactory(final ObjectFactory<ApiKeys> addressFactory) {
        this.apiKeysFactory = apiKeysFactory;
    }
}
