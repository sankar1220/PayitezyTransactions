package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "apiDetails", collectionRelation = "apiDetails")
public class ApiDetailsResource extends ResourceWithEmbeddeds {
    private String apiCode;
    private String apiCount;
    private String apiName;
    private String status;
    private String createdDate;
    private String apiDetailsId;

    public String getApiCode() {
        return apiCode;
    }

    /**
     * @return the apiCount
     */
    public String getApiCount() {
        return apiCount;
    }

    public String getApiDetailsId() {
        return apiDetailsId;
    }

    public String getApiName() {
        return apiName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setApiCode(final String apiCode) {
        this.apiCode = apiCode;
    }

    /**
     * @param apiCount
     *            the apiCount to set
     */
    public void setApiCount(final String apiCount) {
        this.apiCount = apiCount;
    }

    public void setApiDetailsId(final String apiDetailsId) {
        this.apiDetailsId = apiDetailsId;
    }

    public void setApiName(final String apiName) {
        this.apiName = apiName;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
