/**
 *
 */
package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

/**
 * @author mohan
 *
 */
@Relation(value = "paymentResource", collectionRelation = "paymentResource")
public class PaymentResource extends ResourceWithEmbeddeds {

    private String paymentId;
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

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
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

    /**
     * @param paymentId
     *            the paymentId to set
     */
    public void setPaymentId(final String paymentId) {
        this.paymentId = paymentId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public void setWalletId(final String walletId) {
        this.walletId = walletId;
    }

}
