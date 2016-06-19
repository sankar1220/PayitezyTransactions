package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MailContext implements IBusinessDelegateContext{
	
	private String userId;
	private String chitId;
	private String chitPlanId;
	private String memberId;
	private String firmId;
	private String firmBranchId;
	private String allUsers;
	private String allMembers;
	private String paymentMonth;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChitId() {
		return chitId;
	}
	public void setChitId(String chitId) {
		this.chitId = chitId;
	}
	public String getChitPlanId() {
		return chitPlanId;
	}
	public void setChitPlanId(String chitPlanId) {
		this.chitPlanId = chitPlanId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFirmId() {
		return firmId;
	}
	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}
	public String getFirmBranchId() {
		return firmBranchId;
	}
	public void setFirmBranchId(String firmBranchId) {
		this.firmBranchId = firmBranchId;
	}
	public String getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(String allUsers) {
		this.allUsers = allUsers;
	}
	public String getAllMembers() {
		return allMembers;
	}
	public void setAllMembers(String allMembers) {
		this.allMembers = allMembers;
	}
	public String getPaymentMonth() {
		return paymentMonth;
	}
	public void setPaymentMonth(String paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	
	

}
