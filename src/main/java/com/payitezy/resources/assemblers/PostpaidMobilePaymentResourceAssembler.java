package com.payitezy.resources.assemblers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.payitezy.controller.MobileOperatorController;
import com.payitezy.controller.MobileRechargeController;
import com.payitezy.model.PostpaidMobilePaymentModel;
import com.payitezy.resources.hal.PostpaidMobilePaymentResource;


@Service
public class PostpaidMobilePaymentResourceAssembler extends EmbeddableResourceAssemblerSupport<PostpaidMobilePaymentModel, PostpaidMobilePaymentResource, MobileRechargeController>{

	@Autowired
	public PostpaidMobilePaymentResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider){
		super(entityLinks, relProvider, MobileRechargeController.class, PostpaidMobilePaymentResource.class);
	}
	
	@Override
	public Link linkToSingleResource(final PostpaidMobilePaymentModel postpaidMobilePaymentModel){
		return entityLinks.linkToSingleResource(PostpaidMobilePaymentResource.class, postpaidMobilePaymentModel.getNumber());
	}
	
	
	 public PostpaidMobilePaymentResource toDetailedResource(final PostpaidMobilePaymentModel entity){
		 final PostpaidMobilePaymentResource resource = createResourceWithId(entity.getNumber(), entity);
		 	 return resource;
	 }
	 
	 public PostpaidMobilePaymentResource toResource(final PostpaidMobilePaymentModel entity){
		 final PostpaidMobilePaymentResource resource = createResourceWithId(entity.getNumber(),entity);
		 BeanUtils.copyProperties(entity, resource);
		 resource.setNumber(entity.getNumber());
		 return resource;
	 }
}
