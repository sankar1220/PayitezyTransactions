package com.payitezy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apiCircleModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiCircleModel extends AbstractModel {
    private String apiDetailsId;
    private String status;
    private String apiCircleCode;
    private String payitezyCircleId;
    private String apiName;
    private String payitezyCircleName;

    public String getApiCircleCode() {
        return apiCircleCode;
    }

    public String getApiDetailsId() {
        return apiDetailsId;
    }

    public String getApiName() {
        return apiName;
    }

    public String getPayitezyCircleId() {
        return payitezyCircleId;
    }

    public String getPayitezyCircleName() {
        return payitezyCircleName;
    }

    public String getStatus() {
        return status;
    }

    public void setApiCircleCode(final String apiCircleCode) {
        this.apiCircleCode = apiCircleCode;
    }

    public void setApiDetailsId(final String apiDetailsId) {
        this.apiDetailsId = apiDetailsId;
    }

    public void setApiName(final String apiName) {
        this.apiName = apiName;
    }

    public void setPayitezyCircleId(final String payitezyCircleId) {
        this.payitezyCircleId = payitezyCircleId;
    }

    public void setPayitezyCircleName(final String payitezyCircleName) {
        this.payitezyCircleName = payitezyCircleName;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
