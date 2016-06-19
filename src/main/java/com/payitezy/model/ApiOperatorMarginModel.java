package com.payitezy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apiOperatorMarginModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiOperatorMarginModel extends AbstractModel {

    private String payitezyOperatorId;
    private String apiDetailsId;
    private String apiOperatorId;
    private String margin;
    private String rechargesStatus;
    private String status;
    private String createdDate;
    private String mobileOperatorCheck;

    public String getApiDetailsId() {
        return apiDetailsId;
    }

    public String getApiOperatorId() {
        return apiOperatorId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getMargin() {
        return margin;
    }

    public String getMobileOperatorCheck() {
        return mobileOperatorCheck;
    }

    public String getPayitezyOperatorId() {
        return payitezyOperatorId;
    }

    public String getRechargesStatus() {
        return rechargesStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setApiDetailsId(final String apiDetailsId) {
        this.apiDetailsId = apiDetailsId;
    }

    public void setApiOperatorId(final String apiOperatorId) {
        this.apiOperatorId = apiOperatorId;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setMargin(final String margin) {
        this.margin = margin;
    }

    public void setMobileOperatorCheck(final String mobileOperatorCheck) {
        this.mobileOperatorCheck = mobileOperatorCheck;
    }

    public void setPayitezyOperatorId(final String payitezyOperatorId) {
        this.payitezyOperatorId = payitezyOperatorId;
    }

    public void setRechargesStatus(final String rechargesStatus) {
        this.rechargesStatus = rechargesStatus;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
