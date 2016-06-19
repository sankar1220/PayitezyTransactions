package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PayitezyCircleContext implements IBusinessDelegateContext {

    private String payitezyCircleId;
    private String all;

    public String getAll() {
        return all;
    }

    public String getPayitezyCircleId() {
        return payitezyCircleId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setPayitezyCircleId(final String payitezyCircleId) {
        this.payitezyCircleId = payitezyCircleId;
    }

}
