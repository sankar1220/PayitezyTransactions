package com.payitezy.model.converters;

import com.payitezy.domain.UserAddress;
import com.payitezy.model.UserAddressModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("userAddressModelToUserAddressConverter")
public class UserAddressModelToUserAddressConverter implements Converter<UserAddressModel, UserAddress> {
    @Autowired
    private ObjectFactory<UserAddress> userAddressFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserAddress convert(final UserAddressModel source) {
        UserAddress userAddress = userAddressFactory.getObject();
        BeanUtils.copyProperties(source, userAddress);

        return userAddress;
    }

    @Autowired
    public void setUserAdressFactory(final ObjectFactory<UserAddress> userAddressFactory) {
        this.userAddressFactory = userAddressFactory;
    }

}
