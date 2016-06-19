package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.PostpaidMobilePaymentContext;
import com.payitezy.businessdelegate.service.PrepaidMobileRechargeContext;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.model.PrepaidMobileRechargeModel;
import com.payitezy.resources.assemblers.PostpaidMobilePaymentResourceAssembler;
import com.payitezy.resources.assemblers.PrepaidMobileRechargeResourceAssembler;
import com.payitezy.resources.hal.PostpaidMobilePaymentResource;
import com.payitezy.resources.hal.PrepaidMobileRechargeResource;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ExposesResourceFor(value = PrepaidMobileRechargeResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/mobileRecharge", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class MobileRechargeController {

    @Autowired
    private PrepaidMobileRechargeResourceAssembler prepaidMobileRechargeResourceAssembler;
    private IBusinessDelegate<PrepaidMobileRechargeModel, PrepaidMobileRechargeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PrepaidMobileRechargeContext> prepaidMobileRechargeObjectFactory;

    @Autowired
    private PostpaidMobilePaymentResourceAssembler postpaidMobilePaymentResourceAssembler;
    private IBusinessDelegate<PostpaidMobilePaymentModel, PostpaidMobilePaymentContext, IKeyBuilder<String>, String> postpaidBusinessDelegate;
    private ObjectFactory<PostpaidMobilePaymentContext> postpaidMobilePaymentObjectFactory;

    /*
     * @RequestMapping(method = RequestMethod.GET,
     * value="/mobileRecharge/{mobileNumber}")
     * 
     * @ResponseBody public ResponseEntity<PrepaidMobileRechargeHal>
     * getMobileRechargeByMobileNumber(@PathVariable(value="mobileNumber") final
     * String mobileNumber,@RequestParam(value="circle") final String
     * circle,@RequestParam(value="operator")final String
     * operator,@RequestParam(value="amount")final String amount){
     * PrepaidMobileRechargeHal prepaidMobileRechargeHal = new
     * PrepaidMobileRechargeHal(); prepaidMobileRechargeHal.setAmount(amount);
     * prepaidMobileRechargeHal.setCircle(circle);
     * prepaidMobileRechargeHal.setMobileNumber(mobileNumber);
     * prepaidMobileRechargeHal.setOperator(operator); prepaidMobileRechargeHal
     * = businessDelegate.create(prepaidMobileRechargeHal); return new
     * ResponseEntity
     * <PrepaidMobileRechargeHal>(prepaidMobileRechargeHal,HttpStatus.CREATED);
     * }
     */

    @RequestMapping(method = RequestMethod.POST, value = "/createPostpaidMobilePayment", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PostpaidMobilePaymentResource> createPostpaidMobilePaymentByMobileNumber(
            @RequestBody final PostpaidMobilePaymentModel model) {

        PostpaidMobilePaymentModel postpaidMobilePaymentModel = postpaidBusinessDelegate.create(model);

        PostpaidMobilePaymentResource postpaidMobilePaymentResource = postpaidMobilePaymentResourceAssembler
                .toResource(postpaidMobilePaymentModel);

        return new ResponseEntity<PostpaidMobilePaymentResource>(postpaidMobilePaymentResource, HttpStatus.OK);
    }

    /*prepaid Mobile Recharge Payment Method*/
    @RequestMapping(method = RequestMethod.POST, value = "/createPrepaidMobileRecharge", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PrepaidMobileRechargeResource> createPrepaidMobileRechargeByMobileNumber(
            @RequestBody final PrepaidMobileRechargeModel model) {
        PrepaidMobileRechargeModel prepaidMobileRechargeModel = businessDelegate.create(model);
        PrepaidMobileRechargeResource prepaidMobileRechargeResource = prepaidMobileRechargeResourceAssembler
                .toResource(prepaidMobileRechargeModel);
        return new ResponseEntity<PrepaidMobileRechargeResource>(prepaidMobileRechargeResource, HttpStatus.CREATED);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "prepaidMobileRechargeBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /*Postpaid Mobile Payment Method*/

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "postpaidMobilePaymentBusinessDelegate")
    public void setPostpaidBusinessDelegate(final IBusinessDelegate postpaidBusinessDelegate) {
        this.postpaidBusinessDelegate = postpaidBusinessDelegate;
    }

    @Autowired
    public void setPostpaidMobilePaymentObjectFactory(final ObjectFactory<PostpaidMobilePaymentContext> postpaidMobilePaymentObjectFactory) {
        this.postpaidMobilePaymentObjectFactory = postpaidMobilePaymentObjectFactory;
    }

    @Autowired
    public void setPrepaidMobileRechargeObjectFactory(final ObjectFactory<PrepaidMobileRechargeContext> prepaidMobileRechargeObjectFactory) {
        this.prepaidMobileRechargeObjectFactory = prepaidMobileRechargeObjectFactory;
    }

}
