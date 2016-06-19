package com.payitezy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apiDetailsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiDetailsModel extends AbstractModel {
    private String apiCode;
    private String apiCount;
    private String apiName;
    private String status;
    private String createdDate;
    private List<ApiKeysModel> apiKeyModels = new ArrayList<ApiKeysModel>(0);
    private List<ApiOperatorMarginModel> apiOperatorMarginModels = new ArrayList<ApiOperatorMarginModel>(0);

    public String getApiCode() {
        return apiCode;
    }

    /**
     * @return the apiCount
     */
    public String getApiCount() {
        return apiCount;
    }

    public List<ApiKeysModel> getApiKeyModels() {
        return apiKeyModels;
    }

    public String getApiName() {
        return apiName;
    }

    public List<ApiOperatorMarginModel> getApiOperatorMarginModels() {
        return apiOperatorMarginModels;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setApiCode(final String apiCode) {
        this.apiCode = apiCode;
    }

    /**
     * @param apiCount
     *            the apiCount to set
     */
    public void setApiCount(final String apiCount) {
        this.apiCount = apiCount;
    }

    public void setApiKeyModels(final List<ApiKeysModel> apiKeyModels) {
        this.apiKeyModels = apiKeyModels;
    }

    public void setApiName(final String apiName) {
        this.apiName = apiName;
    }

    public void setApiOperatorMarginModels(final List<ApiOperatorMarginModel> apiOperatorMarginModels) {
        this.apiOperatorMarginModels = apiOperatorMarginModels;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
