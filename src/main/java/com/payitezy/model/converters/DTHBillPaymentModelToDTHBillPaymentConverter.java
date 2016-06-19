package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.DTHBillPayment;
import com.payitezy.model.DTHBillPaymentModel;

@Component("dthBillPaymentModelToDTHBillPaymentConverter")
public class DTHBillPaymentModelToDTHBillPaymentConverter implements Converter<DTHBillPaymentModel, DTHBillPayment>{

	private ObjectFactory<DTHBillPayment> dthBillPaymentObjectFactory;

	@Override
	public DTHBillPayment convert(DTHBillPaymentModel source) {
		// TODO Auto-generated method stub
		DTHBillPayment dthBillPaymentObject = dthBillPaymentObjectFactory.getObject();
		BeanUtils.copyProperties(source, dthBillPaymentObject);
		return dthBillPaymentObject;
	}
	
	@Autowired
	public void setDTHBillPayment(final ObjectFactory<DTHBillPayment> dthBillPaymentObjectFactory){
		this.dthBillPaymentObjectFactory=dthBillPaymentObjectFactory;
		
	}
	
	 
	
}
