package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;
import org.springframework.stereotype.Component;

@Component
@Relation(value = "payitezyCircleResource", collectionRelation = "payitezyCircleResource")
public class PayitezyCircleResource extends ResourceWithEmbeddeds {

    private String payitezyCircleId;
    private String circleName;
    private String status;
    private String description;

    public String getCircleName() {
        return circleName;
    }

    public String getDescription() {
        return description;
    }

    public String getPayitezyCircleId() {
        return payitezyCircleId;
    }

    public String getStatus() {
        return status;
    }

    public void setCircleName(final String circleName) {
        this.circleName = circleName;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPayitezyCircleId(final String payitezyCircleId) {
        this.payitezyCircleId = payitezyCircleId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
