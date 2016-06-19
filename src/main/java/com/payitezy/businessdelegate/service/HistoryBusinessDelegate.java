package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.AddressModel;
import com.payitezy.model.HistoryModel;

	@Service
	public class HistoryBusinessDelegate implements IBusinessDelegate<HistoryModel, HistoryContext, IKeyBuilder<String>, String> {

	    Logger LOGGER = Logger.getLogger(HistoryBusinessDelegate.class);

		@Override
		public HistoryModel create(HistoryModel model) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(IKeyBuilder<String> keyBuilder,
				HistoryContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public HistoryModel edit(IKeyBuilder<String> keyBuilder,
				HistoryModel model) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public HistoryModel getByKey(IKeyBuilder<String> keyBuilder,
				HistoryContext context) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<HistoryModel> getCollection(HistoryContext context) {
			// TODO Auto-generated method stub
			return null;
		}
	    
	   
}
