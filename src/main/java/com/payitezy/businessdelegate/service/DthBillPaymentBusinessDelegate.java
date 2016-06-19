package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.payitezy.apiobjects.DTHBillPayment;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.DTHBillPaymentModel;
import com.payitezy.service.IDTHBillPaymentService;

@Service
public class DthBillPaymentBusinessDelegate
		implements
		IBusinessDelegate<DTHBillPaymentModel, DTHBillPaymentContext, IKeyBuilder<String>, String> {

	@Autowired
	private ConversionService conversionService;
	@Autowired
	private IDTHBillPaymentService dthBillPaymentService;

	@Override
	public DTHBillPaymentModel create(DTHBillPaymentModel model) {
		// TODO Auto-generated method stub
		DTHBillPayment dthBillPayment = new DTHBillPayment();
		dthBillPayment.setCircle(model.getCircle());
		dthBillPayment.setOperator(model.getOperator());
		dthBillPayment.setNumber(model.getNumber());
		dthBillPayment.setAmount(model.getAmount());
		dthBillPayment = dthBillPaymentService.dthBillPayment(dthBillPayment);
		model = conversionService.convert(dthBillPayment,
				DTHBillPaymentModel.class);

		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder,
			DTHBillPaymentContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public DTHBillPaymentModel edit(IKeyBuilder<String> keyBuilder,
			DTHBillPaymentModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTHBillPaymentModel getByKey(IKeyBuilder<String> keyBuilder,
			DTHBillPaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DTHBillPaymentModel> getCollection(
			DTHBillPaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
