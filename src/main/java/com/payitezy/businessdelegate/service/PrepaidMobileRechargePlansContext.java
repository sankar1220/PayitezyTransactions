package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrepaidMobileRechargePlansContext implements IBusinessDelegateContext {

    private String id;
    private String operatorId;
    private String circleId;
    private String mobileNumber;
    private String recharge_amount;
    private String recharge_talktime;
    private String recharge_validity;
    private String recharge_shortdesc;
    private String recharge_longdesc;
    private String recharge_type;
    private String limit;
    private String operatorName;
    private String circleName;

    public String getCircleId() {
        return circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public String getId() {
        return id;
    }

    public String getLimit() {
        return limit;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getRecharge_amount() {
        return recharge_amount;
    }

    public String getRecharge_longdesc() {
        return recharge_longdesc;
    }

    public String getRecharge_shortdesc() {
        return recharge_shortdesc;
    }

    public String getRecharge_talktime() {
        return recharge_talktime;
    }

    public String getRecharge_type() {
        return recharge_type;
    }

    public String getRecharge_validity() {
        return recharge_validity;
    }

    public void setCircleId(final String circleId) {
        this.circleId = circleId;
    }

    public void setCircleName(final String circleName) {
        this.circleName = circleName;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLimit(final String limit) {
        this.limit = limit;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setOperatorId(final String operatorId) {
        this.operatorId = operatorId;
    }

    public void setOperatorName(final String operatorName) {
        this.operatorName = operatorName;
    }

    public void setRecharge_amount(final String recharge_amount) {
        this.recharge_amount = recharge_amount;
    }

    public void setRecharge_longdesc(final String recharge_longdesc) {
        this.recharge_longdesc = recharge_longdesc;
    }

    public void setRecharge_shortdesc(final String recharge_shortdesc) {
        this.recharge_shortdesc = recharge_shortdesc;
    }

    public void setRecharge_talktime(final String recharge_talktime) {
        this.recharge_talktime = recharge_talktime;
    }

    public void setRecharge_type(final String recharge_type) {
        this.recharge_type = recharge_type;
    }

    public void setRecharge_validity(final String recharge_validity) {
        this.recharge_validity = recharge_validity;
    }
}
