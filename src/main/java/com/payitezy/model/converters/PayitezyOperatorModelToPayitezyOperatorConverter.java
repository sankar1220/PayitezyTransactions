
/**
 *
 */
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

import com.payitezy.apiobjects.PrepaidMobileRecharge;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.domain.PayitezyOperator;
import com.payitezy.domain.UserAddress;
import com.payitezy.model.PayitezyOperatorModel;
import com.payitezy.util.CollectionTypeDescriptor;

/**
 * Class to convert address model domain to address
 *
 * @author naveen
 *
 */
@Component("payitezyOperatorModelToPayitezyOperatorConverter")
public class PayitezyOperatorModelToPayitezyOperatorConverter implements Converter<PayitezyOperatorModel, PayitezyOperator> {
    @Autowired
    private ObjectFactory<PayitezyOperator> payitezyOperatorFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PayitezyOperator convert(final PayitezyOperatorModel source) {
        PayitezyOperator payitezyOperator = payitezyOperatorFactory.getObject();
        BeanUtils.copyProperties(source, payitezyOperator);
        if (CollectionUtils.isNotEmpty(source.getApiOperatorMarginModels())) {
            List<ApiOperatorMargin> converted = (List<ApiOperatorMargin>) conversionService.convert(source.getApiOperatorMarginModels(),
                    TypeDescriptor.forObject(source.getApiOperatorMarginModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ApiOperatorMargin.class));
            payitezyOperator.getApiOperatorMargins().addAll(converted);
        }

        return payitezyOperator;
    }

    @Autowired
    public void setPayitezyOperatorFactory(final ObjectFactory<PayitezyOperator> payitezyOperatorFactory) {
        this.payitezyOperatorFactory = payitezyOperatorFactory;
    }

}
