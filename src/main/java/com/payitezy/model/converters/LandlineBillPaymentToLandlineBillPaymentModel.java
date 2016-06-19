package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.LandlineBillPayment;
import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.model.LandlineBillPaymentModel;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.model.PrepaidMobileRechargeModel;


@Component("landlineBillPaymentToLandlineBillPaymentModel")
public class LandlineBillPaymentToLandlineBillPaymentModel implements Converter<LandlineBillPayment, LandlineBillPaymentModel> {

	@Autowired
	private ObjectFactory<LandlineBillPaymentModel> landlineBillPaymentModelFactory;
	
	
	@Override
	public LandlineBillPaymentModel convert(final LandlineBillPayment source){
		LandlineBillPaymentModel landlineBillPaymentModel = landlineBillPaymentModelFactory.getObject();
		BeanUtils.copyProperties(source, landlineBillPaymentModel);
		return landlineBillPaymentModel;
	}
	
	@Autowired
	public void setLandlineBillPaymentModelFactory(final ObjectFactory<LandlineBillPaymentModel> landlineBillPaymentModelFactory){
		this.landlineBillPaymentModelFactory= landlineBillPaymentModelFactory;
		
		
	}
	
}
