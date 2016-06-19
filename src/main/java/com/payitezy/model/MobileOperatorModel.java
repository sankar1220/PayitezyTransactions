package com.payitezy.model;

import org.springframework.stereotype.Component;


@Component("mobileOperatorModel")
public class MobileOperatorModel  {
	private String error;
	private String circle;
	private String message;
	private String operator;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	
}
