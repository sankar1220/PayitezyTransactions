package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.model.PostpaidMobilePaymentModel;


@Component("postpaidMobilePaymentModelToPostpaidMobilePayment")
public class PostpaidMobilePaymentModelToPostpaidMobilePayment implements Converter<PostpaidMobilePaymentModel, PostpaidMobilePayment>{

	private ObjectFactory<PostpaidMobilePayment> postpaidMobilePaymentFactory;
	
	
	@Override
	public PostpaidMobilePayment convert(final PostpaidMobilePaymentModel source){
		PostpaidMobilePayment postpaidMobilePayment = postpaidMobilePaymentFactory.getObject();
		BeanUtils.copyProperties(source, postpaidMobilePayment);
		
		return postpaidMobilePayment;
	}
	
	public void setPostpaidMobilePaymentFactory(final ObjectFactory<PostpaidMobilePayment> postpaidMobilePaymentFactory){
		this.postpaidMobilePaymentFactory= postpaidMobilePaymentFactory;
		
		
		
	}
	
}
