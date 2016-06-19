package com.payitezy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apiKeysModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiKeysModel extends AbstractModel {

    private String apiDetails;
    private String keyName;
    private String keyValue;
    private String status;
    private String createdDate;

    public String getApiDetails() {
        return apiDetails;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public String getStatus() {
        return status;
    }

    public void setApiDetails(final String apiDetails) {
        this.apiDetails = apiDetails;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setKeyName(final String keyName) {
        this.keyName = keyName;
    }

    public void setKeyValue(final String keyValue) {
        this.keyValue = keyValue;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
