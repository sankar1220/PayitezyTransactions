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
public class TransactionContext implements IBusinessDelegateContext {

    private String transactionId;
    private String all;

    public String getAll() {
        return all;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

}
