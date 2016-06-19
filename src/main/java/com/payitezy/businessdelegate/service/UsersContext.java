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
public class UsersContext implements IBusinessDelegateContext {

    private String userId;
    private String userType;
    private String emailId;
    private String mobileNo;
    private String password;
    private String changePassword;
    private String newPassword;
    private String confirmPassword;
    private String entityId;
    private String forgotPasswordStatus;
    private String all;
    private String onlyActiveUsers;
    private String currentPassword;

    public String getAll() {
        return all;
    }

    public String getChangePassword() {
        return changePassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getForgotPasswordStatus() {
        return forgotPasswordStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOnlyActiveUsers() {
        return onlyActiveUsers;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setChangePassword(final String changePassword) {
        this.changePassword = changePassword;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setCurrentPassword(final String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public void setEntityId(final String entityId) {
        this.entityId = entityId;
    }

    public void setForgotPasswordStatus(final String forgotPasswordStatus) {
        this.forgotPasswordStatus = forgotPasswordStatus;
    }

    public void setMobileNo(final String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public void setOnlyActiveUsers(final String onlyActiveUsers) {
        this.onlyActiveUsers = onlyActiveUsers;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

}
