package com.payitezy.resources.assemblers;

import com.payitezy.controller.PayitezyOperatorController;
import com.payitezy.model.PayitezyOperatorModel;
import com.payitezy.resources.hal.PayitezyOperatorResource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class PayitezyOperatorResourceAssembler extends
        EmbeddableResourceAssemblerSupport<PayitezyOperatorModel, PayitezyOperatorResource, PayitezyOperatorController> {

    @Autowired
    public PayitezyOperatorResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, PayitezyOperatorController.class, PayitezyOperatorResource.class);
    }

    @Override
    public Link linkToSingleResource(final PayitezyOperatorModel payitezyOperatorModel) {
        return entityLinks.linkToSingleResource(PayitezyOperatorResource.class, payitezyOperatorModel.getId());
    }

    public PayitezyOperatorResource toDetailedResource(final PayitezyOperatorModel entity) {
        final PayitezyOperatorResource resource = createResourceWithId(entity.getId(), entity);
        return resource;
    }

    @Override
    public PayitezyOperatorResource toResource(final PayitezyOperatorModel entity) {
        final PayitezyOperatorResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setPayitezyOperatorId(entity.getId());

        return resource;
    }
}
