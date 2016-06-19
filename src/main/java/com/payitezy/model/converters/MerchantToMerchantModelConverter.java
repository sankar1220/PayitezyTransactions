package com.payitezy.model.converters;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.domain.Merchant;
import com.payitezy.model.ClickTransactionModel;
import com.payitezy.model.MerchantModel;

import com.payitezy.util.CollectionTypeDescriptor;

/**
 * @author Naveen
 *
 */
@Component("merchantToMerchantModelConverter")
public class MerchantToMerchantModelConverter implements Converter<Merchant, MerchantModel> {

    @Autowired
    private ObjectFactory<MerchantModel> merchantModelFactory;
    private static final Logger LOGGER = Logger.getLogger(MerchantToMerchantModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public MerchantModel convert(final Merchant source) {
        // TODO Auto-generated method stub
    	MerchantModel merchantModel = merchantModelFactory.getObject();

        BeanUtils.copyProperties(source, merchantModel);
        if (CollectionUtils.isNotEmpty(source.getClickTransactions())) {
            List<ClickTransactionModel> converted = (List<ClickTransactionModel>) conversionService.convert(source.getClickTransactions(),
                    TypeDescriptor.forObject(source.getClickTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ClickTransactionModel.class));
            merchantModel.getClickTransactionModels().addAll(converted);
        }
        return merchantModel;

    }

    @Autowired
    public void setMerchantFactory(final ObjectFactory<MerchantModel> merchantModelFactory) {
        this.merchantModelFactory = merchantModelFactory;
    }
}
