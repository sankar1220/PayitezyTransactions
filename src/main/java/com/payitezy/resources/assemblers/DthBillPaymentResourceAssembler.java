package com.payitezy.resources.assemblers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.payitezy.controller.DTHBillPaymentController;
import com.payitezy.model.DTHBillPaymentModel;
import com.payitezy.resources.hal.DTHBillPaymentResource;


@Service
public class DthBillPaymentResourceAssembler extends EmbeddableResourceAssemblerSupport<DTHBillPaymentModel, DTHBillPaymentResource, DTHBillPaymentController>{
@Autowired
	public DthBillPaymentResourceAssembler(EntityLinks entityLinks,RelProvider relProvider) {
		super(entityLinks, relProvider, DTHBillPaymentController.class, DTHBillPaymentResource.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Link linkToSingleResource(final DTHBillPaymentModel dthBillPaymentModel){
		return entityLinks.linkToSingleResource(DTHBillPaymentResource.class, dthBillPaymentModel.getNumber());
	}
	
	
	 public DTHBillPaymentResource toDetailedResource(final DTHBillPaymentModel entity){
		 final DTHBillPaymentResource resource = createResourceWithId(entity.getNumber(), entity);
		 	 return resource;
	 }
	 
	 public DTHBillPaymentResource toResource(final DTHBillPaymentModel entity){
		 final DTHBillPaymentResource resource = createResourceWithId(entity.getNumber(),entity);
		 BeanUtils.copyProperties(entity, resource);
		 resource.setNumber(entity.getNumber());
		 return resource;
	 }

	
}
