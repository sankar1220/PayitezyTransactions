package com.payitezy.businessdelegate.service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.UserAddressModel;

import java.util.Collection;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:mail.properties")
public class UserAddressBusinessDelegate implements IBusinessDelegate<UserAddressModel, UserAddressContext, IKeyBuilder<String>, String> {

    @Override
    public UserAddressModel create(final UserAddressModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserAddressContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserAddressModel edit(final IKeyBuilder<String> keyBuilder, final UserAddressModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserAddressModel getByKey(final IKeyBuilder<String> keyBuilder, final UserAddressContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<UserAddressModel> getCollection(final UserAddressContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
