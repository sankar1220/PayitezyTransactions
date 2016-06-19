/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Payment;
import com.payitezy.domain.RechargeTransaction;
import com.payitezy.domain.Transaction;
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
 * @author mohan
 *
 */
@Component("transactionModelToTransactionConverter")
public class TransactionModelToTransactionConverter implements Converter<TransactionModel, Transaction> {
    @Autowired
    private ObjectFactory<Transaction> transactionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Transaction convert(final TransactionModel source) {
        Transaction transaction = transactionFactory.getObject();
        BeanUtils.copyProperties(source, transaction);

        if (CollectionUtils.isNotEmpty(source.getPaymentsModels())) {
            List<Payment> converted = (List<Payment>) conversionService.convert(source.getPaymentsModels(),
                    TypeDescriptor.forObject(source.getPaymentsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Payment.class));
            transaction.getPayments().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getRechargeTransactionsModels())) {
            List<RechargeTransaction> converted = (List<RechargeTransaction>) conversionService.convert(
                    source.getRechargeTransactionsModels(), TypeDescriptor.forObject(source.getPaymentsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RechargeTransaction.class));
            transaction.getRechargeTransactions().addAll(converted);
        }
        return transaction;
    }

    @Autowired
    public void setTransactionFactory(final ObjectFactory<Transaction> transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

}
