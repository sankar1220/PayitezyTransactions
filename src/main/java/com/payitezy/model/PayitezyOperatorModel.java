package com.payitezy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("payitezyOperatorModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PayitezyOperatorModel extends AbstractModel {

    private String payitezyOperatorCode;
    private String payitezyOperatorName;
    private String status;
    private String createdDate;
    private String payitezyOperatorCount;
    private String payitezyOperatorType;
    private List<ApiOperatorMarginModel> apiOperatorMarginModels = new ArrayList<ApiOperatorMarginModel>(0);

    public List<ApiOperatorMarginModel> getApiOperatorMarginModels() {
        return apiOperatorMarginModels;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getPayitezyOperatorCode() {
        return payitezyOperatorCode;
    }

    /**
     * @return the payitezyOperatorCount
     */
    public String getPayitezyOperatorCount() {
        return payitezyOperatorCount;
    }

    public String getPayitezyOperatorName() {
        return payitezyOperatorName;
    }

    public String getPayitezyOperatorType() {
        return payitezyOperatorType;
    }

    public String getStatus() {
        return status;
    }

    public void setApiOperatorMarginModels(final List<ApiOperatorMarginModel> apiOperatorMarginModels) {
        this.apiOperatorMarginModels = apiOperatorMarginModels;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setPayitezyOperatorCode(final String payitezyOperatorCode) {
        this.payitezyOperatorCode = payitezyOperatorCode;
    }

    /**
     * @param payitezyOperatorCount
     *            the payitezyOperatorCount to set
     */
    public void setPayitezyOperatorCount(final String payitezyOperatorCount) {
        this.payitezyOperatorCount = payitezyOperatorCount;
    }

    public void setPayitezyOperatorName(final String payitezyOperatorName) {
        this.payitezyOperatorName = payitezyOperatorName;
    }

    public void setPayitezyOperatorType(final String payitezyOperatorType) {
        this.payitezyOperatorType = payitezyOperatorType;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
