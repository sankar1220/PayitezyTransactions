package com.payitezy.service;

import com.payitezy.domain.UserAddress;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IUserAddressService {

    UserAddress create(UserAddress uad);

    void deleteUserAddress(String userAddressId);

    List<UserAddress> getAll();

    /**
     * @param string
     * @return
     */
    UserAddress getUserAddress(String userAddressId);

    UserAddress updateUserAddress(UserAddress userAddress);
}
