package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiKeysContext implements IBusinessDelegateContext{

	private String apiKeysId;
	private String all;
	public String getApiKeysId() {
		return apiKeysId;
	}
	public void setApiKeysId(String apiKeysId) {
		this.apiKeysId = apiKeysId;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	
}
