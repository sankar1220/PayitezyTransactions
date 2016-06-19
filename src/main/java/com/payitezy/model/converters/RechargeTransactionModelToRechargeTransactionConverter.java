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
@Component("rechargeTransactionModelToRechargeTransactionConverter")
public class RechargeTransactionModelToRechargeTransactionConverter implements Converter<RechargeTransactionModel, RechargeTransaction> {
    @Autowired
    private ObjectFactory<RechargeTransaction> rechargeTransactionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public RechargeTransaction convert(final RechargeTransactionModel source) {
        RechargeTransaction rechargeTransaction = rechargeTransactionFactory.getObject();
        BeanUtils.copyProperties(source, rechargeTransaction);

        return rechargeTransaction;
    }

    @Autowired
    public void setRechargeTransactionFactory(final ObjectFactory<RechargeTransaction> rechargeTransactionFactory) {
        this.rechargeTransactionFactory = rechargeTransactionFactory;
    }

}
