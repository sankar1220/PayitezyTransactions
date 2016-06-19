package com.payitezy.resources.assemblers;

import com.payitezy.controller.ApiKeysController;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.resources.hal.ApiKeysResource;

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
public class ApiKeysResourceAssembler extends EmbeddableResourceAssemblerSupport<ApiKeysModel, ApiKeysResource, ApiKeysController> {

    @Autowired
    public ApiKeysResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, ApiKeysController.class, ApiKeysResource.class);
    }

    @Override
    public Link linkToSingleResource(final ApiKeysModel apiKeysModel) {
        return entityLinks.linkToSingleResource(ApiKeysResource.class, apiKeysModel.getId());
    }

    public ApiKeysResource toDetailedResource(final ApiKeysModel entity) {
        final ApiKeysResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public ApiKeysResource toResource(final ApiKeysModel entity) {
        final ApiKeysResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setApiKeysId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
