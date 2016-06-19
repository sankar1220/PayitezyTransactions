package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.DTHBillPayment;
import com.payitezy.model.DTHBillPaymentModel;

@Component("dthBillPaymentToDTHBillPaymentModelConverter")
public class DTHBillPaymentToDTHBillPaymentModelConverter implements Converter<DTHBillPayment,DTHBillPaymentModel>{

	private ObjectFactory<DTHBillPaymentModel> dthBillPaymentModel;
	@Override
	public DTHBillPaymentModel convert(DTHBillPayment source) {
		// TODO Auto-generated method stub
		DTHBillPaymentModel dthBillPaymentModelObj = dthBillPaymentModel.getObject();
		BeanUtils.copyProperties(source, dthBillPaymentModelObj);
		
		return dthBillPaymentModelObj;
	}
	
	@Autowired
	public void setDTHBillPaymentModelFactory(final ObjectFactory<DTHBillPaymentModel> dthBillPaymentModelFactory){
		this.dthBillPaymentModel= dthBillPaymentModelFactory;
		
	}

}
