package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "apiCircleResource", collectionRelation = "apiCircleResource")
public class ApiCircleResource extends ResourceWithEmbeddeds {
    private String apiCircleId;
    private String apiDetailsId;
    private String status;
    private String apiCircleCode;
    private String payitezyCircleId;
    private String apiName;
    private String payitezyCircleName;

    public String getApiCircleCode() {
        return apiCircleCode;
    }

    public String getApiCircleId() {
        return apiCircleId;
    }

    public String getApiDetailsId() {
        return apiDetailsId;
    }

    public String getApiName() {
        return apiName;
    }

    public String getPayitezyCircleId() {
        return payitezyCircleId;
    }

    public String getPayitezyCircleName() {
        return payitezyCircleName;
    }

    public String getStatus() {
        return status;
    }

    public void setApiCircleCode(final String apiCircleCode) {
        this.apiCircleCode = apiCircleCode;
    }

    public void setApiCircleId(final String apiCircleId) {
        this.apiCircleId = apiCircleId;
    }

    public void setApiDetailsId(final String apiDetailsId) {
        this.apiDetailsId = apiDetailsId;
    }

    public void setApiName(final String apiName) {
        this.apiName = apiName;
    }

    public void setPayitezyCircleId(final String payitezyCircleId) {
        this.payitezyCircleId = payitezyCircleId;
    }

    public void setPayitezyCircleName(final String payitezyCircleName) {
        this.payitezyCircleName = payitezyCircleName;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
