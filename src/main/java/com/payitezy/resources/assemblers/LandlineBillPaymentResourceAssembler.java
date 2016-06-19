

package com.payitezy.resources.assemblers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.payitezy.controller.LandlineBillPaymentController;
import com.payitezy.model.LandlineBillPaymentModel;
import com.payitezy.resources.hal.LandlineBillPaymentResource;


@Service
public class LandlineBillPaymentResourceAssembler extends EmbeddableResourceAssemblerSupport<LandlineBillPaymentModel, LandlineBillPaymentResource, LandlineBillPaymentController>{

	@Autowired
	public LandlineBillPaymentResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider){
		super(entityLinks, relProvider, LandlineBillPaymentController.class, LandlineBillPaymentResource.class);
	}
	
	@Override
	public Link linkToSingleResource(final LandlineBillPaymentModel landlineBillPaymentModel){
		return entityLinks.linkToSingleResource(LandlineBillPaymentResource.class, landlineBillPaymentModel.getNumber());
	}
	
	
	 public LandlineBillPaymentResource toDetailedResource(final LandlineBillPaymentModel entity){
		 final LandlineBillPaymentResource resource = createResourceWithId(entity.getNumber(), entity);
		 	 return resource;
	 }
	 
	 public LandlineBillPaymentResource toResource(final LandlineBillPaymentModel entity){
		 final LandlineBillPaymentResource resource = createResourceWithId(entity.getNumber(),entity);
		 BeanUtils.copyProperties(entity, resource);
		 resource.setNumber(entity.getNumber());
		 return resource;
	 }
}
