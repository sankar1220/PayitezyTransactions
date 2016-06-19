/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Transaction;
import com.payitezy.model.PaymentModel;
import com.payitezy.model.RechargeTransactionModel;
import com.payitezy.model.TransactionModel;
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

/**
 * @author venky
 *
 */
@Component("transactionToTransactionModelConverter")
public class TransactionToTransactionModelConverter implements Converter<Transaction, TransactionModel> {
    @Autowired
    private ObjectFactory<TransactionModel> transactionModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public TransactionModel convert(final Transaction source) {
        TransactionModel transactionModel = transactionModelFactory.getObject();
        BeanUtils.copyProperties(source, transactionModel);

        if (CollectionUtils.isNotEmpty(source.getPayments())) {
            List<PaymentModel> converted = (List<PaymentModel>) conversionService.convert(source.getPayments(),
                    TypeDescriptor.forObject(source.getPayments()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), PaymentModel.class));
            transactionModel.getPaymentsModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getRechargeTransactions())) {
            List<RechargeTransactionModel> converted = (List<RechargeTransactionModel>) conversionService.convert(
                    source.getRechargeTransactions(), TypeDescriptor.forObject(source.getPayments()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RechargeTransactionModel.class));
            transactionModel.getRechargeTransactionsModels().addAll(converted);
        }
        return transactionModel;
    }

    @Autowired
    public void setTransactionModelFactory(final ObjectFactory<TransactionModel> transactionModelFactory) {
        this.transactionModelFactory = transactionModelFactory;
    }

}
