package com.payitezy.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "payitezy_circle", catalog = "payitezy")
public class PayitezyCircle extends AbstractDomain implements java.io.Serializable {

    private String circleName;
    private String status;
    private String description;
    private Set<ApiCircle> apiCircles = new HashSet<ApiCircle>(0);

    public PayitezyCircle() {
    }

    public PayitezyCircle(final String circleName, final String id, final String status, final String description) {
        this.id = id;
        this.circleName = circleName;
        this.description = description;
        this.status = status;

    }

    public PayitezyCircle(final String circleName, final String id, final String status, final String description,
            final Set<ApiCircle> apiCircles) {
        this.id = id;
        this.circleName = circleName;
        this.description = description;
        this.status = status;
        setApiCircles(apiCircles);

    }

    /**
     * @return the apiCircles
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payitezyCircle")
    public Set<ApiCircle> getApiCircles() {
        return apiCircles;
    }

    @Column(name = "circle_Name", nullable = false)
    public String getCircleName() {
        return circleName;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    /**
     * @param apiCircles
     *            the apiCircles to set
     */
    public void setApiCircles(final Set<ApiCircle> apiCircles) {
        this.apiCircles = apiCircles;
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
