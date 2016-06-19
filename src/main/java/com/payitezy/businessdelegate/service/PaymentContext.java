/**
 *
 */
package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author mohan
 *
 */

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentContext implements IBusinessDelegateContext {

    private String paymentId;
    private String all;

    public String getAll() {
        return all;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setPaymentId(final String paymentId) {
        this.paymentId = paymentId;
    }

}
