package com.payitezy.model.converters;

import com.payitezy.domain.ApiDetails;
import com.payitezy.model.ApiDetailsModel;
import com.payitezy.model.ApiKeysModel;
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

@Component("apiDetailsToApiDetailsModelConverter")
public class ApiDetailsToApiDetailsModelConverter implements Converter<ApiDetails, ApiDetailsModel> {
    @Autowired
    private ObjectFactory<ApiDetailsModel> apiDetailsModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ApiDetailsModel convert(final ApiDetails source) {
        ApiDetailsModel apiDetailsModel = apiDetailsModelFactory.getObject();
        BeanUtils.copyProperties(source, apiDetailsModel);

        if (CollectionUtils.isNotEmpty(source.getApiKeyses())) {
            List<ApiKeysModel> converted = (List<ApiKeysModel>) conversionService.convert(source.getApiKeyses(),
                    TypeDescriptor.forObject(source.getApiKeyses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiKeysModel.class));
            apiDetailsModel.getApiKeyModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getApiOperatorMargins())) {
            List<ApiOperatorMarginModel> converted = (List<ApiOperatorMarginModel>) conversionService.convert(
                    source.getApiOperatorMargins(), TypeDescriptor.forObject(source.getApiOperatorMargins()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiOperatorMarginModel.class));
            apiDetailsModel.getApiOperatorMarginModels().addAll(converted);
        }

        return apiDetailsModel;
    }

    @Autowired
    public void setApiDetailsModelFactory(final ObjectFactory<ApiDetailsModel> apiDetailsModelFactory) {
        this.apiDetailsModelFactory = apiDetailsModelFactory;
    }
}
