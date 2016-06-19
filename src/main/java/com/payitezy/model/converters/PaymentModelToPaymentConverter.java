/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Payment;
import com.payitezy.model.PaymentModel;

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
@Component("paymentModelToPaymentConverter")
public class PaymentModelToPaymentConverter implements Converter<PaymentModel, Payment> {
    @Autowired
    private ObjectFactory<Payment> paymentFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Payment convert(final PaymentModel source) {
        Payment payment = paymentFactory.getObject();
        BeanUtils.copyProperties(source, payment);

        return payment;
    }

    @Autowired
    public void setPaymentFactory(final ObjectFactory<Payment> paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

}
