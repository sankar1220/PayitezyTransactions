package com.payitezy.model.converters;

import com.payitezy.domain.UserAddress;
import com.payitezy.model.UserAddressModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("userAddressToUserAddressModelConverter")
public class UserAddressToUserAddressModelConverter implements Converter<UserAddress, UserAddressModel> {
    @Autowired
    private ObjectFactory<UserAddressModel> userAddressModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserAddressModel convert(final UserAddress source) {
        UserAddressModel userAddressModel = userAddressModelFactory.getObject();
        BeanUtils.copyProperties(source, userAddressModel);

        return userAddressModel;
    }

    @Autowired
    public void setUserAdressModelFactory(final ObjectFactory<UserAddressModel> userAddressModelFactory) {
        this.userAddressModelFactory = userAddressModelFactory;
    }

}
