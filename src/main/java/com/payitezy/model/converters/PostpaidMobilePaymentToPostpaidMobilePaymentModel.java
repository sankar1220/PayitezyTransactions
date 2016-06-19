package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.model.PrepaidMobileRechargeModel;


@Component("postpaidMobilePaymentToPostpaidMobilePaymentModel")
public class PostpaidMobilePaymentToPostpaidMobilePaymentModel implements Converter<PostpaidMobilePayment, PostpaidMobilePaymentModel> {

	@Autowired
	private ObjectFactory<PostpaidMobilePaymentModel> postpaidMobilePaymentModelFactory;
	
	
	@Override
	public PostpaidMobilePaymentModel convert(final PostpaidMobilePayment source){
		PostpaidMobilePaymentModel postpaidMobilePaymentModel = postpaidMobilePaymentModelFactory.getObject();
		BeanUtils.copyProperties(source, postpaidMobilePaymentModel);
		return postpaidMobilePaymentModel;
	}
	
	@Autowired
	public void setPostpaidMobilePaymentModelFactory(final ObjectFactory<PostpaidMobilePaymentModel> postpaidMobilePaymentModelFactory){
		this.postpaidMobilePaymentModelFactory= postpaidMobilePaymentModelFactory;
		
		
	}
	
}
