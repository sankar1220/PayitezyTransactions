package com.payitezy.businessdelegate.service;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HistoryContext implements IBusinessDelegateContext{
private String historyId;
private String all;
public String getHistoryId() {
	return historyId;
}
public void setHistoryId(String historyId) {
	this.historyId = historyId;
}
public String getAll() {
	return all;
}
public void setAll(String all) {
	this.all = all;
}

	
}
