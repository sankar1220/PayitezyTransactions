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
import com.payitezy.domain.ApiDetails;
import com.payitezy.domain.ApiKeys;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.domain.UserAddress;
import com.payitezy.model.AddressModel;
import com.payitezy.model.ApiDetailsModel;
import com.payitezy.util.CollectionTypeDescriptor;

@Component("apiDetailsModelToApiDetailsConverter")
public class ApiDetailsModelToApiDetailsConverter implements Converter<ApiDetailsModel, ApiDetails> {
    @Autowired
    private ObjectFactory<ApiDetails> apiDetailsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiDetails convert(final ApiDetailsModel source) {
    	ApiDetails apiDetails= apiDetailsFactory.getObject();
        BeanUtils.copyProperties(source, apiDetails);

        if (CollectionUtils.isNotEmpty(source.getApiKeyModels())) {
            List<ApiKeys> converted = (List<ApiKeys>) conversionService.convert(source.getApiKeyModels(),
                    TypeDescriptor.forObject(source.getApiKeyModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiKeys.class));
            apiDetails.getApiKeyses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getApiOperatorMarginModels())) {
            List<ApiOperatorMargin> converted = (List<ApiOperatorMargin>) conversionService.convert(source.getApiOperatorMarginModels(),
                    TypeDescriptor.forObject(source.getApiOperatorMarginModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiOperatorMargin.class));
            apiDetails.getApiOperatorMargins().addAll(converted);
        }

        return apiDetails;
    }

    @Autowired
    public void setApiDetailsFactory(final ObjectFactory<ApiDetails> apiDetailsFactory) {
        this.apiDetailsFactory = apiDetailsFactory;
    }

}
