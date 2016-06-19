package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.model.MerchantModel;
@Service
public class MerchantBusinessDelegate implements IBusinessDelegate<MerchantModel, MerchantContext, IKeyBuilder<String>, String> {

    Logger LOGGER = Logger.getLogger(MerchantBusinessDelegate.class);

	@Override
	public MerchantModel create(MerchantModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, MerchantContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MerchantModel edit(IKeyBuilder<String> keyBuilder,
			MerchantModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantModel getByKey(IKeyBuilder<String> keyBuilder,
			MerchantContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MerchantModel> getCollection(MerchantContext context) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
