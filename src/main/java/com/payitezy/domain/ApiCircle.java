package com.payitezy.domain;

import javax.persistence.*;

@Entity
@Table(name = "api_circle", catalog = "payitezy")
public class ApiCircle extends AbstractDomain implements java.io.Serializable {

    private ApiDetails apiDetails;
    private String status;
    private String apiCircleCode;
    private PayitezyCircle payitezyCircle;

    public ApiCircle() {

    }

    public ApiCircle(final ApiDetails apiDetails, final String status, final String apiCircleCode, final PayitezyCircle payitezyCircle) {
        super();
        this.apiDetails = apiDetails;
        this.status = status;
        this.apiCircleCode = apiCircleCode;
        this.payitezyCircle = payitezyCircle;
    }

    @Column(name = "api_circle_code")
    public String getApiCircleCode() {
        return apiCircleCode;
    }

    /**
     * @return the apiDetails
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "api_details_id", nullable = false)
    public ApiDetails getApiDetails() {
        return apiDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payitezy_circle_id", nullable = false)
    public PayitezyCircle getPayitezyCircle() {
        return payitezyCircle;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setApiCircleCode(final String apiCircleCode) {
        this.apiCircleCode = apiCircleCode;
    }

    /**
     * @param apiDetails
     *            the apiDetails to set
     */
    public void setApiDetails(final ApiDetails apiDetails) {
        this.apiDetails = apiDetails;
    }

    public void setPayitezyCircle(final PayitezyCircle payitezyCircle) {
        this.payitezyCircle = payitezyCircle;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
