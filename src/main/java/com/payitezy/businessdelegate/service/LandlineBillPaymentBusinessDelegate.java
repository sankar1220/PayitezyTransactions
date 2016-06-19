package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.payitezy.apiobjects.LandlineBillPayment;
import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.LandlineBillPaymentModel;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.service.ILandlineBillPaymentService;
import com.payitezy.service.LandlineBillPaymentService;
import com.payitezy.service.PostpaidMobilePaymentService;

@Service
public class LandlineBillPaymentBusinessDelegate implements IBusinessDelegate<LandlineBillPaymentModel, LandlineBillPaymentContext, IKeyBuilder<String>, String>{

	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ILandlineBillPaymentService landlineBillPaymentService;
	
	@Override
	public LandlineBillPaymentModel create(LandlineBillPaymentModel model) {
		// TODO Auto-generated method stub
		LandlineBillPayment landlineBillPayment= new LandlineBillPayment();
		landlineBillPayment.setCircle(model.getCircle());
		landlineBillPayment.setOperator(model.getOperator());
		landlineBillPayment.setNumber(model.getNumber());
		landlineBillPayment.setAmount(model.getAmount());
		landlineBillPayment = landlineBillPaymentService.landlineBillPayment(landlineBillPayment);
		LandlineBillPaymentModel landlineBillPaymentModel = conversionService.convert(landlineBillPayment, LandlineBillPaymentModel.class);
		
		return landlineBillPaymentModel;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder,
			LandlineBillPaymentContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LandlineBillPaymentModel edit(IKeyBuilder<String> keyBuilder,
			LandlineBillPaymentModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LandlineBillPaymentModel getByKey(IKeyBuilder<String> keyBuilder,
			LandlineBillPaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<LandlineBillPaymentModel> getCollection(
			LandlineBillPaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
