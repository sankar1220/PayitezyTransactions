/**
 *
 */
package com.payitezy.model.converters;

import com.payitezy.domain.Users;
import com.payitezy.model.TransactionModel;
import com.payitezy.model.UserAddressModel;
import com.payitezy.model.UsersModel;
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

/**
 * @author mohan
 *
 */
@Component("usersToUsersModelConverter")
public class UsersToUsersModelConverter implements Converter<Users, UsersModel> {
    @Autowired
    private ObjectFactory<UsersModel> usersModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersModel convert(final Users source) {
        UsersModel usersModel = usersModelFactory.getObject();
        BeanUtils.copyProperties(source, usersModel);
        usersModel.setMobileNo(source.getMobileNo());
        if (CollectionUtils.isNotEmpty(source.getTransactions())) {
            List<TransactionModel> converted = (List<TransactionModel>) conversionService.convert(source.getTransactions(),
                    TypeDescriptor.forObject(source.getTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TransactionModel.class));
            usersModel.getTransactionsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserAddress())) {
            List<UserAddressModel> converted = (List<UserAddressModel>) conversionService.convert(source.getUserAddress(),
                    TypeDescriptor.forObject(source.getUserAddress()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserAddressModel.class));
            usersModel.getUserAddressModels().addAll(converted);
        }
        return usersModel;
    }

    @Autowired
    public void setUsersModelFactory(final ObjectFactory<UsersModel> usersModelFactory) {
        this.usersModelFactory = usersModelFactory;
    }

}