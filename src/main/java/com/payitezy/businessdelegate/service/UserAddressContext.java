package com.payitezy.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAddressContext implements IBusinessDelegateContext {

    private String userAddressId;
    private String all;

    public String getAll() {
        return all;
    }

    public String getUserAddressId() {
        return userAddressId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setUserAddressId(final String userAddressId) {
        this.userAddressId = userAddressId;
    }

}
