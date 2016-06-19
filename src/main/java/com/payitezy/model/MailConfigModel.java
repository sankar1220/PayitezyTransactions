package com.payitezy.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("mailConfigModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MailConfigModel extends AbstractModel {
    private String usersId;
    private String mailAttributeName;
    private String mailAttributeValue;
    private String status;
    private String createdDate;
    private String modifiedDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getMailAttributeName() {
        return mailAttributeName;
    }

    public String getMailAttributeValue() {
        return mailAttributeValue;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setMailAttributeName(final String mailAttributeName) {
        this.mailAttributeName = mailAttributeName;
    }

    public void setMailAttributeValue(final String mailAttributeValue) {
        this.mailAttributeValue = mailAttributeValue;
    }

    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
