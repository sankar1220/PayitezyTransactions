package com.payitezy.resources.assemblers;

import com.payitezy.controller.ApiCircleController;
import com.payitezy.model.ApiCircleModel;
import com.payitezy.resources.hal.ApiCircleResource;
import com.payitezy.resources.hal.ApiDetailsResource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class ApiCircleResourceAssembler extends EmbeddableResourceAssemblerSupport<ApiCircleModel, ApiCircleResource, ApiCircleController> {

    @Autowired
    public ApiCircleResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, ApiCircleController.class, ApiCircleResource.class);
    }

    @Override
    public Link linkToSingleResource(final ApiCircleModel apiCircleModel) {
        return entityLinks.linkToSingleResource(ApiDetailsResource.class, apiCircleModel.getId());
    }

    public ApiCircleResource toDetailedResource(final ApiCircleModel entity) {
        final ApiCircleResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public ApiCircleResource toResource(final ApiCircleModel entity) {
        final ApiCircleResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setApiDetailsId(entity.getId());
        /*
                final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

                resource.setEmbeddeds(new Resources<>(embeddables));*/
        return resource;
    }

}
