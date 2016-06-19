package com.payitezy.model.converters;
import com.payitezy.domain.Address;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.domain.UserAddress;
import com.payitezy.domain.Users;
import com.payitezy.model.AddressModel;
import com.payitezy.model.ApiOperatorMarginModel;
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
@Component("apiOperatorMarginModelToApiOperatorMarginConverter")
public class ApiOperatorMarginModelToApiOperatorMarginConverter implements Converter<ApiOperatorMarginModel, ApiOperatorMargin> {
    @Autowired
    private ObjectFactory<ApiOperatorMargin> apiOperatorMarginFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiOperatorMargin convert(final ApiOperatorMarginModel source) {
        ApiOperatorMargin apiOperatorMargin = apiOperatorMarginFactory.getObject();
        BeanUtils.copyProperties(source, apiOperatorMargin);

        return apiOperatorMargin;
    }

    @Autowired
    public void setApiOperatorMarginFactory(final ObjectFactory<ApiOperatorMargin> apiOperatorMarginFactory) {
        this.apiOperatorMarginFactory = apiOperatorMarginFactory;
    }

	
}
