package com.payitezy.resources.assemblers;

import com.payitezy.controller.PrepaidMobileRechargePlanController;
import com.payitezy.model.PrepaidMobileRechargePlansModel;
import com.payitezy.resources.hal.PrepaidMobileRechargePlanResource;
import com.payitezy.resources.hal.PrepaidMobileRechargeResource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class PrepaidMobileRechargePlanAssembler
        extends
        EmbeddableResourceAssemblerSupport<PrepaidMobileRechargePlansModel, PrepaidMobileRechargePlanResource, PrepaidMobileRechargePlanController> {

    @Autowired
    public PrepaidMobileRechargePlanAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, PrepaidMobileRechargePlanController.class, PrepaidMobileRechargePlanResource.class);
    }

    @Override
    public Link linkToSingleResource(final PrepaidMobileRechargePlansModel prepaidMobileRechargePlansModel) {
        return entityLinks.linkToSingleResource(PrepaidMobileRechargeResource.class, prepaidMobileRechargePlansModel.getId());
    }

    public PrepaidMobileRechargePlanResource toDetailedResource(final PrepaidMobileRechargePlansModel entity) {
        final PrepaidMobileRechargePlanResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public PrepaidMobileRechargePlanResource toResource(final PrepaidMobileRechargePlansModel entity) {
        final PrepaidMobileRechargePlanResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setPlanId(entity.getId());
        if (entity.getRecharge_talktime() != null) {
            System.out.println(entity.getRecharge_talktime());
        }
        else {
            resource.setRecharge_talktime("0");
        }
        // Add (multiple) links to authored books

        return resource;
    }
}
