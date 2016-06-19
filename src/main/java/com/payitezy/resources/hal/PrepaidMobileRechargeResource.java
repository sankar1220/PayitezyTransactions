package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "prepaidMobileRecharge", collectionRelation = "prepaidMobileRecharge")
public class PrepaidMobileRechargeResource extends ResourceWithEmbeddeds{

	private String transactionId;
	private String status;
	private String amount;
	private String number;
	private String operator;
	private String error_code;
	private String message;
	private String time;
	private String userTxid;
	

	private String operatorReference;
	private String circle;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserTxid() {
		return userTxid;
	}
	public void setUserTxid(String userTxid) {
		this.userTxid = userTxid;
	}

	public String getOperatorReference() {
		return operatorReference;
	}
	public void setOperatorReference(String operatorReference) {
		this.operatorReference = operatorReference;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	
}
