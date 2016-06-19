package com.payitezy.service;

import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.merchanturls.smsacharya.SmsAcharyaMobileRechargeResources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileOperatorService implements IMobileOperatorService {

    @Autowired
    private SmsAcharyaMobileRechargeResources smsAcharyaMobileResource;
    @Autowired
    private IPayitezyOperatorService payitezyOperatorService;
    @Autowired
    private IPayitezyCircleService payitezyCircleService;

    @Override
    public MobileOperator getMobileOperatorCircleByMobileNumber(final String mobileNumber) {
        MobileOperator mobileOperator = smsAcharyaMobileResource.getMobileOperatorCircleByMobileNumber(mobileNumber);

        String payitezyOperator = (payitezyOperatorService.getPayitezyOperatorByApiOperator(mobileOperator.getOperator())).getId();
        String payitezyCircle = ((payitezyCircleService.getPayitezyCircleByApiCircle(mobileOperator.getCircle())).getId());
        mobileOperator.setCircle(payitezyCircle);
        mobileOperator.setOperator(payitezyOperator);
        return mobileOperator;
    }

}
