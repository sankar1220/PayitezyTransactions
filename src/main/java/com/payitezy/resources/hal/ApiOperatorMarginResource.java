package com.payitezy.resources.hal;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;
@Relation(value = "apiOperatorMargin", collectionRelation = "apiOperatorMargin")
public class ApiOperatorMarginResource extends ResourceWithEmbeddeds {
	private String apiOperatorMarginId;
	private String payitezyOperatorId;
	private String apiDetailsId;
	private String apiOperatorId;
	private String margin;
	private String rechargesStatus;
	private String status;
	private String createdDate;
	private String mobileOperatorCheck;
	public String getApiOperatorMarginId() {
		return apiOperatorMarginId;
	}
	public void setApiOperatorMarginId(String apiOperatorMarginId) {
		this.apiOperatorMarginId = apiOperatorMarginId;
	}
	public String getPayitezyOperatorId() {
		return payitezyOperatorId;
	}
	public void setPayitezyOperatorId(String payitezyOperatorId) {
		this.payitezyOperatorId = payitezyOperatorId;
	}
	public String getApiDetailsId() {
		return apiDetailsId;
	}
	public void setApiDetailsId(String apiDetailsId) {
		this.apiDetailsId = apiDetailsId;
	}
	public String getApiOperatorId() {
		return apiOperatorId;
	}
	public void setApiOperatorId(String apiOperatorId) {
		this.apiOperatorId = apiOperatorId;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getRechargesStatus() {
		return rechargesStatus;
	}
	public void setRechargesStatus(String rechargesStatus) {
		this.rechargesStatus = rechargesStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getMobileOperatorCheck() {
		return mobileOperatorCheck;
	}
	public void setMobileOperatorCheck(String mobileOperatorCheck) {
		this.mobileOperatorCheck = mobileOperatorCheck;
	}
	
}
