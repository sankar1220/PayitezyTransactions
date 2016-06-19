package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.PayitezyCircleContext;
import com.payitezy.businessdelegate.service.PrepaidMobileRechargePlansContext;
import com.payitezy.merchanturls.datayuge.PrepaidMobileRechargePlanResources;
import com.payitezy.model.PayitezyCircleModel;
import com.payitezy.model.PrepaidMobileRechargePlansModel;
import com.payitezy.resources.assemblers.PrepaidMobileRechargePlanAssembler;
import com.payitezy.resources.hal.MobileOperatorResource;
import com.payitezy.resources.hal.PrepaidMobileRechargePlanResource;

import java.util.List;

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
@ExposesResourceFor(value = MobileOperatorResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/prepaidMobileRechargePlan")
public class PrepaidMobileRechargePlanController {

    @Autowired
    private PrepaidMobileRechargePlanResources prepaidMobileRechargePlanResources;

    private IBusinessDelegate<PrepaidMobileRechargePlansModel, PrepaidMobileRechargePlansContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PrepaidMobileRechargePlansContext> prepaidMobileRechargePlansObjectFactory;

    private IBusinessDelegate<PayitezyCircleModel, PayitezyCircleContext, IKeyBuilder<String>, String> payitezyBusinessDelegate;
    private ObjectFactory<PayitezyCircleContext> payitezyCircleObjectFactory;

    @Autowired
    private PrepaidMobileRechargePlanAssembler prepaidMobileRechargePlanAssembler;

    @RequestMapping(value = "/plans/{circleId}/{operatorId}", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<PrepaidMobileRechargePlanResource>> getRechargePlansByNumberByCircleByOperator(

            @PathVariable(value = "circleId") final String circleId, @PathVariable(value = "operatorId") final String operatorId,
            @RequestParam(value = "limit", defaultValue = "", required = false) final String limit) {

        PrepaidMobileRechargePlansContext prepaidContext = new PrepaidMobileRechargePlansContext();
        prepaidContext.setCircleId(circleId);
        prepaidContext.setOperatorId(operatorId);

        prepaidContext.setLimit(limit);
        List<PrepaidMobileRechargePlansModel> prepaidMobileRechargePlansModels = (List<PrepaidMobileRechargePlansModel>) businessDelegate
                .getCollection(prepaidContext);

        Iterable<PrepaidMobileRechargePlanResource> prepaidHalResources = prepaidMobileRechargePlanAssembler
                .toResources(prepaidMobileRechargePlansModels);

        return new ResponseEntity<Iterable<PrepaidMobileRechargePlanResource>>(prepaidHalResources, HttpStatus.OK);

    }

    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> objectFactory) {
        keyBuilderFactory = objectFactory;
    }

    @Resource(name = "prepaidMobileRechargePlansBusinessDelegate")
    public void setPrepaidMobileRechargePlansBusinessDelegate(final IBusinessDelegate businessDelagate) {
        businessDelegate = businessDelagate;
    }

    @Autowired
    public void setPrepaidMobileRechargePlansObjectFactory(
            final ObjectFactory<PrepaidMobileRechargePlansContext> prepaidMobileRechargePlansObjectFactory) {
        this.prepaidMobileRechargePlansObjectFactory = prepaidMobileRechargePlansObjectFactory;
    }
}
