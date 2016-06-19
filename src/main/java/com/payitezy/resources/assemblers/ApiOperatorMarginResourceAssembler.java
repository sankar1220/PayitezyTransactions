package com.payitezy.resources.assemblers;

import com.payitezy.controller.ApiOperatorMarginController;
import com.payitezy.model.ApiOperatorMarginModel;
import com.payitezy.resources.hal.ApiOperatorMarginResource;

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
public class ApiOperatorMarginResourceAssembler extends EmbeddableResourceAssemblerSupport<ApiOperatorMarginModel, ApiOperatorMarginResource, ApiOperatorMarginController> {

    @Autowired
    public ApiOperatorMarginResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, ApiOperatorMarginController.class, ApiOperatorMarginResource.class);
    }

    @Override
    public Link linkToSingleResource(final ApiOperatorMarginModel apiOperatorMarginModel) {
        return entityLinks.linkToSingleResource(ApiOperatorMarginResource.class, apiOperatorMarginModel.getId());
    }

    public ApiOperatorMarginResource toDetailedResource(final ApiOperatorMarginModel entity) {
        final ApiOperatorMarginResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public ApiOperatorMarginResource toResource(final ApiOperatorMarginModel entity) {
        final ApiOperatorMarginResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setApiOperatorMarginId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
