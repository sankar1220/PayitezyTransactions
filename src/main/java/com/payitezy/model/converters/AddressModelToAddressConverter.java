package com.payitezy.model.converters;

import com.payitezy.domain.Address;
import com.payitezy.domain.UserAddress;
import com.payitezy.domain.Users;
import com.payitezy.model.AddressModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("addressModelToAddressConverter")
public class AddressModelToAddressConverter implements Converter<AddressModel, Address> {
    @Autowired
    private ObjectFactory<Address> addressFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Address convert(final AddressModel source) {
        Address address = addressFactory.getObject();
        BeanUtils.copyProperties(source, address);

        if (CollectionUtils.isNotEmpty(source.getUserAddressModels())) {
            List<UserAddress> converted = (List<UserAddress>) conversionService.convert(source.getUserAddressModels(),
                    TypeDescriptor.forObject(source.getUserAddressModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Users.class));
            address.getUserAddress().addAll(converted);
        }

        return address;
    }

    @Autowired
    public void setAdressFactory(final ObjectFactory<Address> addressFactory) {
        this.addressFactory = addressFactory;
    }

}