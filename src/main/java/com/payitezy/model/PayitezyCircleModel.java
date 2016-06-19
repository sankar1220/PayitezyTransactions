package com.payitezy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("payitezyCircleModel")
public class PayitezyCircleModel extends AbstractModel {

    private String circleName;
    private String status;
    private String description;
    private List<ApiCircleModel> apiCircleModels = new ArrayList<ApiCircleModel>(0);

    /**
     * @return the apiCircleModels
     */
    public List<ApiCircleModel> getApiCircleModels() {
        return apiCircleModels;
    }

    public String getCircleName() {
        return circleName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * @param apiCircleModels
     *            the apiCircleModels to set
     */
    public void setApiCircleModels(final List<ApiCircleModel> apiCircleModels) {
        this.apiCircleModels = apiCircleModels;
    }

    public void setCircleName(final String circleName) {
        this.circleName = circleName;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
