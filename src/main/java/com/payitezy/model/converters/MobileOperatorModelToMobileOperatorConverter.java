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

import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.model.MobileOperatorModel;

/**
 * Class to convert address model domain to address
 *
 * @author venkyp
 *
 */
@Component("mobileOperatorModelToMobileOperatorConverter")
public class MobileOperatorModelToMobileOperatorConverter implements Converter<MobileOperatorModel, MobileOperator> {
    @Autowired
    private ObjectFactory<MobileOperator> mobileOperatorFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public MobileOperator convert(final MobileOperatorModel source) {
    	MobileOperator mobileOperator = mobileOperatorFactory.getObject();
        BeanUtils.copyProperties(source, mobileOperator);

        return mobileOperator;
    }

    @Autowired
    public void setMobileOperatorFactory(final ObjectFactory<MobileOperator> mobileOperatorFactory) {
        this.mobileOperatorFactory = mobileOperatorFactory;
    }

}
