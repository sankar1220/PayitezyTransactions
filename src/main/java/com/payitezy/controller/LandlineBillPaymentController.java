package com.payitezy.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.LandlineBillPaymentContext;
import com.payitezy.businessdelegate.service.PostpaidMobilePaymentContext;
import com.payitezy.businessdelegate.service.PrepaidMobileRechargeContext;
import com.payitezy.model.LandlineBillPaymentModel;
import com.payitezy.model.PrepaidMobileRechargeModel;
import com.payitezy.resources.assemblers.LandlineBillPaymentResourceAssembler;
import com.payitezy.resources.assemblers.PrepaidMobileRechargeResourceAssembler;
import com.payitezy.resources.hal.LandlineBillPaymentResource;


@RestController
@ExposesResourceFor( value = LandlineBillPaymentResource.class)
@EnableHypermediaSupport(type = {HypermediaType.HAL})
@RequestMapping(value="/landlineBillPayment")
public class LandlineBillPaymentController {

	@Autowired
	private LandlineBillPaymentResourceAssembler landlineBillPaymentResourceAssembler;
	private IBusinessDelegate<LandlineBillPaymentModel, LandlineBillPaymentContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<LandlineBillPaymentContext> landlineBillPaymentObjectFactory;

	@RequestMapping(value="createLandlineBillPayment" , method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LandlineBillPaymentResource> createLandlineBillPaymentByNumber(@RequestBody final LandlineBillPaymentModel model){
	
		LandlineBillPaymentModel landlineBillPaymentModel = businessDelegate.create(model);
		
		LandlineBillPaymentResource resource = landlineBillPaymentResourceAssembler.toResource(landlineBillPaymentModel);
		
		return new ResponseEntity<LandlineBillPaymentResource>(resource,HttpStatus.OK);
		
	}

	
	
	@Autowired
	public void setLandlineBillPaymentObjectFactory(final ObjectFactory<LandlineBillPaymentContext> landlineBillPaymentObjectFactory){
		this.landlineBillPaymentObjectFactory = landlineBillPaymentObjectFactory;
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "landlineBillPaymentBusinessDelegate")
	public void setLandlineBillPaymentBusinessDelegate(final IBusinessDelegate landlineBillPaymentBusinessDelegate) {
		this.businessDelegate = landlineBillPaymentBusinessDelegate;
	}


	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(
			final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
}
