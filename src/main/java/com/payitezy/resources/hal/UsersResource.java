/**
 *
 */
package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

/**
 * @author mohan
 *
 */

@Relation(value = "usersResource", collectionRelation = "usersResource")
public class UsersResource extends ResourceWithEmbeddeds {

    private String usersId;
    private String userName;
    private String age;
    private String emailId;
    private String mobileNo;
    private String password;
    private String newPassword;
    private String userCode;
    private String status;
    private String userType;
    private String alternateMobileNo;
    private String emailStatus;
    private String authenticateStatus;
    private String confirmPassword;
    private String userEmailIdStatus;
    private String userMobileNoStatus;
    private String createdDate;
    private String userCount;

    public String getAge() {
        return age;
    }

    public String getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserCount() {
        return userCount;
    }

    public String getUserEmailIdStatus() {
        return userEmailIdStatus;
    }

    public String getUserMobileNoStatus() {
        return userMobileNoStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getUsersId() {
        return usersId;
    }

    public String getUserType() {
        return userType;
    }

    public void setAge(final String age) {
        this.age = age;
    }

    public void setAlternateMobileNo(final String alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public void setAuthenticateStatus(final String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public void setEmailStatus(final String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void setMobileNo(final String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

    public void setUserCount(final String userCount) {
        this.userCount = userCount;
    }

    public void setUserEmailIdStatus(final String userEmailIdStatus) {
        this.userEmailIdStatus = userEmailIdStatus;
    }

    public void setUserMobileNoStatus(final String userMobileNoStatus) {
        this.userMobileNoStatus = userMobileNoStatus;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

}
