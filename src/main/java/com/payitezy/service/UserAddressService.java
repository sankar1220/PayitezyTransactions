package com.payitezy.service;

import com.payitezy.dao.UserAddressRepository;
import com.payitezy.domain.UserAddress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAddressService implements IUserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public UserAddress create(final UserAddress uad) {
        // TODO Auto-generated method stub
        return userAddressRepository.save(uad);
    }

    @Override
    public void deleteUserAddress(final String userAddressId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<UserAddress> getAll() {
        // TODO Auto-generated method stub
        return (List<UserAddress>) userAddressRepository.findAll();
    }

    @Override
    public UserAddress getUserAddress(final String userAddressId) {
        // TODO Auto-generated method stub
        return userAddressRepository.findOne(userAddressId);
    }

    @Override
    public UserAddress updateUserAddress(final UserAddress userAddress) {
        // TODO Auto-generated method stub
        return userAddressRepository.save(userAddress);
    }

}
