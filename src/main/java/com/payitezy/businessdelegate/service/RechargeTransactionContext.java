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
public class RechargeTransactionContext implements IBusinessDelegateContext {

    private String rechargeTransactionId;
    private String all;

    public String getAll() {
        return all;
    }

    public String getRechargeTransactionId() {
        return rechargeTransactionId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setRechargeTransactionId(final String rechargeTransactionId) {
        this.rechargeTransactionId = rechargeTransactionId;
    }

}