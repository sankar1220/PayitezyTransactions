package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "payitezyOperator", collectionRelation = "payitezyOperator")
public class PayitezyOperatorResource extends ResourceWithEmbeddeds {
    private String payitezyOperatorId;
    private String payitezyOperatorCode;
    private String payitezyOperatorName;
    private String status;
    private String createdDate;
    private String payitezyOperatorCount;
    private String payitezyOperatorType;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getPayitezyOperatorCode() {
        return payitezyOperatorCode;
    }

    /**
     * @return the payitezyOperatorCount
     */
    public String getPayitezyOperatorCount() {
        return payitezyOperatorCount;
    }

    public String getPayitezyOperatorId() {
        return payitezyOperatorId;
    }

    public String getPayitezyOperatorName() {
        return payitezyOperatorName;
    }

    public String getPayitezyOperatorType() {
        return payitezyOperatorType;
    }

    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setPayitezyOperatorCode(final String payitezyOperatorCode) {
        this.payitezyOperatorCode = payitezyOperatorCode;
    }

    /**
     * @param payitezyOperatorCount
     *            the payitezyOperatorCount to set
     */
    public void setPayitezyOperatorCount(final String payitezyOperatorCount) {
        this.payitezyOperatorCount = payitezyOperatorCount;
    }

    public void setPayitezyOperatorId(final String payitezyOperatorId) {
        this.payitezyOperatorId = payitezyOperatorId;
    }

    public void setPayitezyOperatorName(final String payitezyOperatorName) {
        this.payitezyOperatorName = payitezyOperatorName;
    }

    public void setPayitezyOperatorType(final String payitezyOperatorType) {
        this.payitezyOperatorType = payitezyOperatorType;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
