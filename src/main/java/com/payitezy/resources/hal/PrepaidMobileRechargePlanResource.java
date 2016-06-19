package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "prepaidMobileRechargePlan", collectionRelation = "prepaidMobileRechargePlans")
public class PrepaidMobileRechargePlanResource extends ResourceWithEmbeddeds {
	private String planId;
	private String operatorId;
	private String circleId;
	private String recharge_amount;
	private String recharge_talktime;
	private String recharge_validity;
	private String recharge_shortdesc;
	private String recharge_longdesc;
	private String recharge_type;
	/**
	 * @return the planId
	 */
	public String getPlanId() {
		return planId;
	}
	/**
	 * @param planId the planId to set
	 */
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	/**
	 * @return the operatorId
	 */
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * @param operatorId the operatorId to set
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * @return the circleId
	 */
	public String getCircleId() {
		return circleId;
	}
	/**
	 * @param circleId the circleId to set
	 */
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	/**
	 * @return the recharge_amount
	 */
	public String getRecharge_amount() {
		return recharge_amount;
	}
	/**
	 * @param recharge_amount the recharge_amount to set
	 */
	public void setRecharge_amount(String recharge_amount) {
		this.recharge_amount = recharge_amount;
	}
	/**
	 * @return the recharge_talktime
	 */
	public String getRecharge_talktime() {
		return recharge_talktime;
	}
	/**
	 * @param recharge_talktime the recharge_talktime to set
	 */
	public void setRecharge_talktime(String recharge_talktime) {
		this.recharge_talktime = recharge_talktime;
	}
	/**
	 * @return the recharge_validity
	 */
	public String getRecharge_validity() {
		return recharge_validity;
	}
	/**
	 * @param recharge_validity the recharge_validity to set
	 */
	public void setRecharge_validity(String recharge_validity) {
		this.recharge_validity = recharge_validity;
	}
	/**
	 * @return the recharge_shortdesc
	 */
	public String getRecharge_shortdesc() {
		return recharge_shortdesc;
	}
	/**
	 * @param recharge_shortdesc the recharge_shortdesc to set
	 */
	public void setRecharge_shortdesc(String recharge_shortdesc) {
		this.recharge_shortdesc = recharge_shortdesc;
	}
	/**
	 * @return the recharge_longdesc
	 */
	public String getRecharge_longdesc() {
		return recharge_longdesc;
	}
	/**
	 * @param recharge_longdesc the recharge_longdesc to set
	 */
	public void setRecharge_longdesc(String recharge_longdesc) {
		this.recharge_longdesc = recharge_longdesc;
	}
	/**
	 * @return the recharge_type
	 */
	public String getRecharge_type() {
		return recharge_type;
	}
	/**
	 * @param recharge_type the recharge_type to set
	 */
	public void setRecharge_type(String recharge_type) {
		this.recharge_type = recharge_type;
	}
}
