/**
 *
 */
package com.payitezy.resources.hal;

import com.payitezy.domain.Merchant;

import java.math.BigDecimal;

import org.springframework.hateoas.core.Relation;

/**
 * @author mohan
 *
 */
@Relation(value = "transaction", collectionRelation = "transaction")
public class TransactionResource extends ResourceWithEmbeddeds {

    private String transactionId;
    private String usersId;
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
    private BigDecimal cashbackAmount;
    private String refundStatus;
    private Merchant merchant;

    public String getAmount() {
        return amount;
    }

    public BigDecimal getCashbackAmount() {
        return cashbackAmount;
    }

    public String getCode() {
        return code;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getPaymentType() {
        return paymentType;
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

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
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

    public void setCashbackAmount(final BigDecimal cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setMerchant(final Merchant merchant) {
        this.merchant = merchant;
    }

    public void setOrderStatus(final String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
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

    /**
     * @param transactionId
     *            the transactionId to set
     */
    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
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
