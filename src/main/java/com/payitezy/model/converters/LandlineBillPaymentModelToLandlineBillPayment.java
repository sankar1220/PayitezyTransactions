
package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.LandlineBillPayment;
import com.payitezy.model.LandlineBillPaymentModel;


@Component("landlineBillPaymentModelToLandlineBillPayment")
public class LandlineBillPaymentModelToLandlineBillPayment implements Converter<LandlineBillPaymentModel, LandlineBillPayment>{

	private ObjectFactory<LandlineBillPayment> landlineBillPaymentFactory;
	
	
	@Override
	public LandlineBillPayment convert(final LandlineBillPaymentModel source){
		LandlineBillPayment landlineBillPayment = landlineBillPaymentFactory.getObject();
		BeanUtils.copyProperties(source, landlineBillPayment);
		
		return landlineBillPayment;
	}
	
	@Autowired
	public void setLandlineBillPaymentFactory(final ObjectFactory<LandlineBillPayment> landlineBillPaymentFactory){
		this.landlineBillPaymentFactory= landlineBillPaymentFactory;
		
		
		
	}
	
}

