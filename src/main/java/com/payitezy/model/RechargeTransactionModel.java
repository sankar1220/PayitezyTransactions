package com.payitezy.model;

import org.springframework.stereotype.Component;

@Component("rechargeTransactionModel")
public class RechargeTransactionModel extends AbstractModel {

    private String transactionId;
    private String rechargeTransactionCode;
    private String operatorNane;
    private String circleName;
    private String amount;
    private String specialCode;
    private String rechargeType;
    private String mobileNumber;
    private String accountNumber;
    private String operatorId;
    private String circleId;
    private String adminCost;
    private String adminMargin;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAdminCost() {
        return adminCost;
    }

    public String getAdminMargin() {
        return adminMargin;
    }

    public String getAmount() {
        return amount;
    }

    public String getCircleId() {
        return circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getOperatorNane() {
        return operatorNane;
    }

    public String getRechargeTransactionCode() {
        return rechargeTransactionCode;
    }

    public String getRechargeType() {
        return rechargeType;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAdminCost(final String adminCost) {
        this.adminCost = adminCost;
    }

    public void setAdminMargin(final String adminMargin) {
        this.adminMargin = adminMargin;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public void setCircleId(final String circleId) {
        this.circleId = circleId;
    }

    public void setCircleName(final String circleName) {
        this.circleName = circleName;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setOperatorId(final String operatorId) {
        this.operatorId = operatorId;
    }

    public void setOperatorNane(final String operatorNane) {
        this.operatorNane = operatorNane;
    }

    public void setRechargeTransactionCode(final String rechargeTransactionCode) {
        this.rechargeTransactionCode = rechargeTransactionCode;
    }

    public void setRechargeType(final String rechargeType) {
        this.rechargeType = rechargeType;
    }

    public void setSpecialCode(final String specialCode) {
        this.specialCode = specialCode;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

}
