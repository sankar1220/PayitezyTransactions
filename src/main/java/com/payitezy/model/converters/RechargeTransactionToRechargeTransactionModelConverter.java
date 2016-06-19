/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.RechargeTransaction;
import com.payitezy.model.RechargeTransactionModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author mohan
 *
 */
@Component("rechargeTransactionToRechargeTransactionModelConverter")
public class RechargeTransactionToRechargeTransactionModelConverter implements Converter<RechargeTransaction, RechargeTransactionModel> {
    @Autowired
    private ObjectFactory<RechargeTransactionModel> rechargeTransactionModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public RechargeTransactionModel convert(final RechargeTransaction source) {
        RechargeTransactionModel rechargeTransactionModel = rechargeTransactionModelFactory.getObject();
        BeanUtils.copyProperties(source, rechargeTransactionModel);

        return rechargeTransactionModel;
    }

    @Autowired
    public void setRechargeTransactionModelFactory(final ObjectFactory<RechargeTransactionModel> rechargeTransactionModelFactory) {
        this.rechargeTransactionModelFactory = rechargeTransactionModelFactory;
    }

}
