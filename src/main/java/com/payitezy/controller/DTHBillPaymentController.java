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
import com.payitezy.businessdelegate.service.DTHBillPaymentContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.model.DTHBillPaymentModel;
import com.payitezy.resources.assemblers.DthBillPaymentResourceAssembler;
import com.payitezy.resources.hal.DTHBillPaymentResource;


@RestController
@ExposesResourceFor( value = DTHBillPaymentResource.class)
@EnableHypermediaSupport(type = {HypermediaType.HAL})
@RequestMapping(value="/dthBillPayment")
public class DTHBillPaymentController {

	@Autowired
	private DthBillPaymentResourceAssembler dthBillPaymentResourceAssembler;
	private IBusinessDelegate<DTHBillPaymentModel, DTHBillPaymentContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<DTHBillPaymentContext> dthBillPaymentObjectFactory;

	@RequestMapping(value="createDTHBillPayment" , method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DTHBillPaymentResource> createDTHBillPaymentByNumber(@RequestBody final DTHBillPaymentModel model){
	
		DTHBillPaymentModel dthBillPaymentModel = businessDelegate.create(model);
		
		DTHBillPaymentResource resource = dthBillPaymentResourceAssembler.toResource(dthBillPaymentModel);
		
		return new ResponseEntity<DTHBillPaymentResource>(resource,HttpStatus.OK);
		
	}

	
	
	@Autowired
	public void setDTHBillPaymentObjectFactory(final ObjectFactory<DTHBillPaymentContext> dthBillPaymentObjectFactory){
		this.dthBillPaymentObjectFactory = dthBillPaymentObjectFactory;
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "dthBillPaymentBusinessDelegate")
	public void setDTHBillPaymentBusinessDelegate(final IBusinessDelegate dthBillPaymentBusinessDelegate) {
		this.businessDelegate = dthBillPaymentBusinessDelegate;
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
