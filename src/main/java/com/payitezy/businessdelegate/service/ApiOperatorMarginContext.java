package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiOperatorMarginContext implements IBusinessDelegateContext{

private String apiOperatorMarginId;
private String all;
public String getApiOperatorMarginId() {
	return apiOperatorMarginId;
}
public void setApiOperatorMarginId(String apiOperatorMarginId) {
	this.apiOperatorMarginId = apiOperatorMarginId;
}
public String getAll() {
	return all;
}
public void setAll(String all) {
	this.all = all;
}

	
}
