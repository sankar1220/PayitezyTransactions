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
import com.payitezy.domain.ClickTransaction;
import com.payitezy.domain.Merchant;
import com.payitezy.model.MerchantModel;
import com.payitezy.util.CollectionTypeDescriptor;

/**
 * Class to convert address model domain to address
 *
 * @author venkyp
 *
 */
@Component("merchantModelToMerchantConverter")
public class MerchantModelToMerchantConverter implements Converter<MerchantModel, Merchant> {
    @Autowired
    private ObjectFactory<Merchant> merchantFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Merchant convert(final MerchantModel source) {
    	Merchant merchant = merchantFactory.getObject();
        BeanUtils.copyProperties(source, merchant);
        if (CollectionUtils.isNotEmpty(source.getClickTransactionModels())) {
            List<ClickTransaction> converted = (List<ClickTransaction>) conversionService.convert(source.getClickTransactionModels(),
                    TypeDescriptor.forObject(source.getClickTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ClickTransaction.class));
            merchant.getClickTransactions().addAll(converted);
        }
        return merchant;
    }

    @Autowired
    public void setMerchantFactory(final ObjectFactory<Merchant> merchantFactory) {
        this.merchantFactory = merchantFactory;
    }

}
