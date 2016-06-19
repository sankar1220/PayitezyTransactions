package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.AddressModel;
import com.payitezy.model.ClickTransactionModel;

	
	@Service
	public class ClickTransactionBusinessDelegate implements IBusinessDelegate<ClickTransactionModel, ClickTransactionContext, IKeyBuilder<String>, String> {

	    Logger LOGGER = Logger.getLogger(ClickTransactionBusinessDelegate.class);

		@Override
		public ClickTransactionModel create(ClickTransactionModel model) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(IKeyBuilder<String> keyBuilder,
				ClickTransactionContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ClickTransactionModel edit(IKeyBuilder<String> keyBuilder,
				ClickTransactionModel model) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ClickTransactionModel getByKey(IKeyBuilder<String> keyBuilder,
				ClickTransactionContext context) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<ClickTransactionModel> getCollection(
				ClickTransactionContext context) {
			// TODO Auto-generated method stub
			return null;
		}
	   

}
