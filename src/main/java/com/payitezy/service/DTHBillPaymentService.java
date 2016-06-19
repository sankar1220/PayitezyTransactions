package com.payitezy.service;

import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.DTHBillPayment;
import com.payitezy.merchanturls.smsacharya.DTHBillPaymentUrlResource;
import com.payitezy.resources.hal.DTHBillPaymentResource;

@Component
public class DTHBillPaymentService implements IDTHBillPaymentService{

	private DTHBillPaymentUrlResource dthBillPaymentUrlResource;
	@Override
	public DTHBillPayment dthBillPayment(DTHBillPayment dthBillPayment) {
		// TODO Auto-generated method stub
		
		dthBillPayment = dthBillPaymentUrlResource.getDTHBillPaymentByNumber(dthBillPayment);
		return dthBillPayment;
	}
	

}
