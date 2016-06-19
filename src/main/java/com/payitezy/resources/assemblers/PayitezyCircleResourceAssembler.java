package com.payitezy.resources.assemblers;

import com.payitezy.controller.PayitezyCircleController;
import com.payitezy.model.PayitezyCircleModel;
import com.payitezy.resources.hal.PayitezyCircleResource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;

@Service
public class PayitezyCircleResourceAssembler extends
        EmbeddableResourceAssemblerSupport<PayitezyCircleModel, PayitezyCircleResource, PayitezyCircleController> {
    @Autowired
    private PayitezyCircleResource payitezyCircleResource;

    @Autowired
    public PayitezyCircleResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, PayitezyCircleController.class, PayitezyCircleResource.class);
    }

    @Override
    public Link linkToSingleResource(final PayitezyCircleModel payitezyCircleModel) {
        return entityLinks.linkToSingleResource(PayitezyCircleResource.class, payitezyCircleModel.getId());
    }

    public PayitezyCircleResource toDetailedResource(final PayitezyCircleModel entity) {
        final PayitezyCircleResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public PayitezyCircleResource toResource(final PayitezyCircleModel entity) {
        final PayitezyCircleResource resource = createResourceWithId(entity.getId(), entity);

        BeanUtils.copyProperties(entity, resource);
        resource.setPayitezyCircleId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
