package com.payitezy.service;

import com.payitezy.apiobjects.PrepaidMobileRecharge;
import com.payitezy.domain.ApiCircle;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.merchanturls.smsacharya.SmsAcharyaMobileRechargeResources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrepaidMobileRechargeService implements IPrepaidMobileRechargeService {

    @Autowired
    private IApiOperatorMarginService apiOperatorMarginService;
    @Autowired
    private SmsAcharyaMobileRechargeResources smsAcharyaPrepaidMobileRechargeResource;
    @Autowired
    private IApiCircleService apiCircleService;

    @Override
    public PrepaidMobileRecharge rechargePrepaidMobile(PrepaidMobileRecharge prepaidMobileRecharge) {
        String payitezyOperatorId = prepaidMobileRecharge.getOperator();
        String payitezyOperatorCircle = prepaidMobileRecharge.getCircle();

        List<ApiOperatorMargin> operatorWithMargins = apiOperatorMarginService.getApiOperatorSortByMargin(payitezyOperatorId);
        for (ApiOperatorMargin aom : operatorWithMargins) {

            if (aom.getApiDetails().getApiName().equals("SMSACHARYA")) {
                prepaidMobileRecharge.setOperator(aom.getApiOperatorId());
                ApiCircle apiCircle = apiCircleService.getApiCircleByPayitEzyCircle(payitezyOperatorCircle, aom.getApiDetails().getId());
                prepaidMobileRecharge.setCircle(apiCircle.getId());
                prepaidMobileRecharge = smsAcharyaPrepaidMobileRechargeResource
                        .getPrepaidMobileRechargeByMobileNumber(prepaidMobileRecharge);
                if (prepaidMobileRecharge.getStatus().equals("SUCCESS")) {
                    return prepaidMobileRecharge;
                }

            }
        }

        return prepaidMobileRecharge;
    }
}
