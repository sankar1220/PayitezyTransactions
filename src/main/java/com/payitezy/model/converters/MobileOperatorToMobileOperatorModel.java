package com.payitezy.model.converters;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.model.MobileOperatorModel;

/**
 * @author Naveen
 *
 */
@Component("mobileOperatorToMobileOperatorModelConverter")
public class MobileOperatorToMobileOperatorModel implements Converter<MobileOperator, MobileOperatorModel> {

    @Autowired
    private ObjectFactory<MobileOperatorModel> mobileOperatorModelFactory;
    private static final Logger LOGGER = Logger.getLogger(MobileOperatorToMobileOperatorModel.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public MobileOperatorModel convert(final MobileOperator source) {
        // TODO Auto-generated method stub
    	MobileOperatorModel mobileOperatorModel = mobileOperatorModelFactory.getObject();

        BeanUtils.copyProperties(source, mobileOperatorModel);

        return mobileOperatorModel;

    }

    @Autowired
    public void setMobileOperatorFactory(final ObjectFactory<MobileOperatorModel> mobileOperatorModelFactory) {
        this.mobileOperatorModelFactory = mobileOperatorModelFactory;
    }
}
