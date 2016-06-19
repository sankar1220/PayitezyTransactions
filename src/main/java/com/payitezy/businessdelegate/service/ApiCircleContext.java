package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiCircleContext implements IBusinessDelegateContext {
    private String apiCircleId;
    private String all;

    /**
     * @return the all
     */
    public String getAll() {
        return all;
    }

    /**
     * @return the apiCircleId
     */
    public String getApiCircleId() {
        return apiCircleId;
    }

    /**
     * @param all
     *            the all to set
     */
    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param apiCircleId
     *            the apiCircleId to set
     */
    public void setApiCircleId(final String apiCircleId) {
        this.apiCircleId = apiCircleId;
    }
}
