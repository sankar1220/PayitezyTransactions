package com.payitezy.service;

import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.domain.ApiCircle;
import com.payitezy.domain.ApiOperatorMargin;
import com.payitezy.merchanturls.smsacharya.SmsAcharyaMobileRechargeResources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostpaidMobilePaymentService implements IPostpaidMobilePaymentService {

    @Autowired
    private SmsAcharyaMobileRechargeResources postpaidMobilePaymentResource;

    @Autowired
    private IApiOperatorMarginService apiOperatorMarginServiceRef;

    @Autowired
    private IApiCircleService apiCircleServiceRef;

    @Override
    public PostpaidMobilePayment postpaidMobilebillPayment(PostpaidMobilePayment postpaidMobilePayment) {
        // TODO Auto-generated method stub
        String payitezyOperatorId = postpaidMobilePayment.getOperator();
        String payitezyOperatorCircle = postpaidMobilePayment.getCircle();

        List<ApiOperatorMargin> operatorWithMargins = apiOperatorMarginServiceRef.getApiOperatorSortByMargin(payitezyOperatorId);
        for (ApiOperatorMargin aom : operatorWithMargins) {

            if (aom.getApiDetails().getApiName().equals("SMSACHARYA")) {
                postpaidMobilePayment.setOperator(aom.getApiOperatorId());
                ApiCircle apiCircle = apiCircleServiceRef.getApiCircleByPayitEzyCircle(payitezyOperatorCircle, aom.getApiDetails().getId());
                postpaidMobilePayment.setCircle(apiCircle.getId());
                postpaidMobilePayment = postpaidMobilePaymentResource.getPostpaidMobilePaymentByMobileNumber(postpaidMobilePayment);
                if (postpaidMobilePayment.getStatus().equals("SUCCESS")) {
                    return postpaidMobilePayment;
                }

            }
        }

        return postpaidMobilePayment;

    }

}
