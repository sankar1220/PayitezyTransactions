package com.payitezy.service;

import java.util.List;

import com.payitezy.domain.Merchant;
import com.payitezy.domain.Users;

public interface IMerchantService {
	Merchant create(Merchant merchant);

    void deleteMerchant(String merchantId);

    Merchant getMerchant(String merchantId);

    List<Merchant> getAll();	  

    Merchant updateMerchant(Merchant merchant);

}
