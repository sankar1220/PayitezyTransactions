package com.payitezy.businessdelegate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.model.PrepaidMobileRechargeModel;
import com.payitezy.service.PostpaidMobilePaymentService;
@Service
public class PostpaidMobilePaymentBusinessDelegate implements IBusinessDelegate<PostpaidMobilePaymentModel, PostpaidMobilePaymentContext, IKeyBuilder<String>, String> {
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private PostpaidMobilePaymentService postpaidMobilePaymentService;
	@Override
	public PostpaidMobilePaymentModel create(PostpaidMobilePaymentModel model) {
		// TODO Auto-generated method stub
		
		PostpaidMobilePayment postpaidMobilePayment= new PostpaidMobilePayment();
		postpaidMobilePayment.setCircle(model.getCircle());
		postpaidMobilePayment.setOperator(model.getOperator());
		postpaidMobilePayment.setNumber(model.getNumber());
		postpaidMobilePayment.setAmount(model.getAmount());
		postpaidMobilePayment = postpaidMobilePaymentService.postpaidMobilebillPayment(postpaidMobilePayment);
		PostpaidMobilePaymentModel postpaidMobilePaymentModel = conversionService.convert(postpaidMobilePayment, PostpaidMobilePaymentModel.class);
		
		
		return postpaidMobilePaymentModel;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder,
			PostpaidMobilePaymentContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostpaidMobilePaymentModel edit(IKeyBuilder<String> keyBuilder,
			PostpaidMobilePaymentModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostpaidMobilePaymentModel getByKey(IKeyBuilder<String> keyBuilder,
			PostpaidMobilePaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PostpaidMobilePaymentModel> getCollection(
			PostpaidMobilePaymentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
