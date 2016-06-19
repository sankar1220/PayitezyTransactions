package com.payitezy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("transaction")
public class TransactionModel extends AbstractModel {

    private String usersId;
    private String merchantId;
    private String code;
    private String amount;
    private String paymentType;
    private String transacttionFor;
    private String transactionErrorCode;
    private String transactionMerchantErrorCode;
    private String transactionMerchantMsg;
    private String createdDate;
    private String orderStatus;
    private String source;
    private String ur;
    private String cashbackAmount;
    private String refundStatus;
    private String merchant;
    private List<PaymentModel> paymentsModels = new ArrayList<PaymentModel>(0);
    private List<RechargeTransactionModel> rechargeTransactionsModels = new ArrayList<RechargeTransactionModel>(0);

    public String getAmount() {
        return amount;
    }

    public String getCashbackAmount() {
        return cashbackAmount;
    }

    public String getCode() {
        return code;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getMerchant() {
        return merchant;
    }

    /**
     * @return the merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public List<PaymentModel> getPaymentsModels() {
        return paymentsModels;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public List<RechargeTransactionModel> getRechargeTransactionsModels() {
        return rechargeTransactionsModels;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public String getSource() {
        return source;
    }

    public String getTransactionErrorCode() {
        return transactionErrorCode;
    }

    public String getTransactionMerchantErrorCode() {
        return transactionMerchantErrorCode;
    }

    public String getTransactionMerchantMsg() {
        return transactionMerchantMsg;
    }

    public String getTransacttionFor() {
        return transacttionFor;
    }

    public String getUr() {
        return ur;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public void setCashbackAmount(final String cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setMerchant(final String merchant) {
        this.merchant = merchant;
    }

    /**
     * @param merchantId
     *            the merchantId to set
     */
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    public void setOrderStatus(final String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentsModels(final List<PaymentModel> paymentsModels) {
        this.paymentsModels = paymentsModels;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
    }

    public void setRechargeTransactionsModels(final List<RechargeTransactionModel> rechargeTransactionsModels) {
        this.rechargeTransactionsModels = rechargeTransactionsModels;
    }

    public void setRefundStatus(final String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    public void setTransactionErrorCode(final String transactionErrorCode) {
        this.transactionErrorCode = transactionErrorCode;
    }

    public void setTransactionMerchantErrorCode(final String transactionMerchantErrorCode) {
        this.transactionMerchantErrorCode = transactionMerchantErrorCode;
    }

    public void setTransactionMerchantMsg(final String transactionMerchantMsg) {
        this.transactionMerchantMsg = transactionMerchantMsg;
    }

    public void setTransacttionFor(final String transacttionFor) {
        this.transacttionFor = transacttionFor;
    }

    public void setUr(final String ur) {
        this.ur = ur;
    }

    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
