package com.payitezy.resources.assemblers;



import com.payitezy.controller.MobileRechargeController;

import com.payitezy.model.PrepaidMobileRechargeModel;


import com.payitezy.resources.hal.PrepaidMobileRechargeResource;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;

import org.springframework.stereotype.Service;

@Service
public class PrepaidMobileRechargeResourceAssembler extends EmbeddableResourceAssemblerSupport<PrepaidMobileRechargeModel, PrepaidMobileRechargeResource, MobileRechargeController> {

    @Autowired
    public PrepaidMobileRechargeResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, MobileRechargeController.class, PrepaidMobileRechargeResource.class);
    }

    @Override
    public Link linkToSingleResource(final PrepaidMobileRechargeModel prepaidMobileRechargeModel) {
        return entityLinks.linkToSingleResource(PrepaidMobileRechargeResource.class, prepaidMobileRechargeModel.getNumber());
    }

    public PrepaidMobileRechargeResource toDetailedResource(final PrepaidMobileRechargeModel entity) {
        final PrepaidMobileRechargeResource resource = createResourceWithId(entity.getNumber(), entity);

        return resource;
    }

    @Override
    public PrepaidMobileRechargeResource toResource(final PrepaidMobileRechargeModel entity) {
        final PrepaidMobileRechargeResource resource = createResourceWithId(entity.getNumber(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setNumber(entity.getNumber());
        // Add (multiple) links to authored books
        
      
     
        return resource;
    }

}
