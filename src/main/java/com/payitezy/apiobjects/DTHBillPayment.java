package com.payitezy.apiobjects;

import org.springframework.stereotype.Component;

@Component("dthBillPayment")
public class DTHBillPayment {

    private String transactionId;
    private String status;
    private String amount;
    private String number;
    private String operator;
    private String error_code;
    private String message;
    private String time;
    private String userTxid;
    private String yourCost;
    private String balance;
    private String operatorReference;
    private String circle;

    public String getAmount() {
        return amount;
    }

    public String getBalance() {
        return balance;
    }

    public String getCircle() {
        return circle;
    }

    public String getError_code() {
        return error_code;
    }

    public String getMessage() {
        return message;
    }

    public String getNumber() {
        return number;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperatorReference() {
        return operatorReference;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserTxid() {
        return userTxid;
    }

    public String getYourCost() {
        return yourCost;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }

    public void setCircle(final String circle) {
        this.circle = circle;
    }

    public void setError_code(final String error_code) {
        this.error_code = error_code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

    public void setOperatorReference(final String operatorReference) {
        this.operatorReference = operatorReference;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setTime(final String time) {
        this.time = time;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserTxid(final String userTxid) {
        this.userTxid = userTxid;
    }

    public void setYourCost(final String yourCost) {
        this.yourCost = yourCost;
    }

}
