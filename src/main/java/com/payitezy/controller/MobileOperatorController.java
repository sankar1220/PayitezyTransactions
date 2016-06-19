package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.MobileOperatorContext;
import com.payitezy.merchanturls.smsacharya.SmsAcharyaMobileRechargeResources;
import com.payitezy.model.MobileOperatorModel;
import com.payitezy.resources.assemblers.MobileOperatorResourceAssembler;
import com.payitezy.resources.hal.MobileOperatorResource;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ExposesResourceFor(value = MobileOperatorResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/mobileOperator")
public class MobileOperatorController {

    @Autowired
    private SmsAcharyaMobileRechargeResources mobileRechargeResources;

    private IBusinessDelegate<MobileOperatorModel, MobileOperatorContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<MobileOperatorContext> mobileOperatorObjectFactory;
    @Autowired
    private MobileOperatorResourceAssembler mobileOperatorResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/operator/{mobileNumber}")
    @ResponseBody
    public ResponseEntity<MobileOperatorResource> getOperatorsByMobileNumber(@PathVariable(value = "mobileNumber") final String mobileNumber) {

        MobileOperatorContext mobileOperatorContext = new MobileOperatorContext();
        MobileOperatorModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(mobileNumber), mobileOperatorContext);
        MobileOperatorResource mobileOperatorHal = mobileOperatorResourceAssembler.toResource(model);
        return new ResponseEntity<MobileOperatorResource>(mobileOperatorHal, HttpStatus.OK);

    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "mobileOperatorBusinessDelegate")
    public void setMobileOperatorBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setMobileOperatorObjectFactory(final ObjectFactory<MobileOperatorContext> mobileOperatorContextFactory) {
        mobileOperatorObjectFactory = mobileOperatorContextFactory;
    }

}
