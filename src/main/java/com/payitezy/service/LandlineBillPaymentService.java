package com.payitezy.service;

import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.LandlineBillPayment;
import com.payitezy.merchanturls.smsacharya.LandlineBillPaymentUrlResources;

@Component
public class LandlineBillPaymentService implements ILandlineBillPaymentService{

	private LandlineBillPaymentUrlResources landlineBillPaymentUrlResource; 
	@Override
	public LandlineBillPayment landlineBillPayment(
			LandlineBillPayment landlineBillPayment) {
		// TODO Auto-generated method stub
		
	landlineBillPayment = landlineBillPaymentUrlResource.getLandLineBillPaymentByNumber(landlineBillPayment);
	
		return landlineBillPayment;
	}

}
