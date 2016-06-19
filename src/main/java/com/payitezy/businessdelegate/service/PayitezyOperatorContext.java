package com.payitezy.businessdelegate.service;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PayitezyOperatorContext implements IBusinessDelegateContext{
private String payitezyOperatorId;
private String all;
public String getPayitezyOperatorId() {
	return payitezyOperatorId;
}
public void setPayitezyOperatorId(String payitezyOperatorId) {
	this.payitezyOperatorId = payitezyOperatorId;
}
public String getAll() {
	return all;
}
public void setAll(String all) {
	this.all = all;
}

	
}
