
package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiDetailsContext implements IBusinessDelegateContext{

private String apiDetailsId;
private String all;

public String getAll() {
	return all;
}

public void setAll(String all) {
	this.all = all;
}

public String getApiDetailsId() {
	return apiDetailsId;
}

public void setApiDetailsId(String apiDetailsId) {
	this.apiDetailsId = apiDetailsId;
}


}
