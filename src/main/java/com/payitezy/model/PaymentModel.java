package com.payitezy.model;

import org.springframework.stereotype.Component;

@Component("paymentModel")
public class PaymentModel extends AbstractModel {

    private String transactionId;
    private String cardType;
    private String nameOnCard;
    private String walletId;

    public String getCardType() {
        return cardType;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public void setNameOnCard(final String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setWalletId(final String walletId) {
        this.walletId = walletId;
    }

}
