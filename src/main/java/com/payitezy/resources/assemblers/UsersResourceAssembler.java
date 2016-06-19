package com.payitezy.resources.assemblers;

import com.payitezy.controller.UsersController;
import com.payitezy.model.UsersModel;
import com.payitezy.resources.hal.UsersResource;

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
public class UsersResourceAssembler extends EmbeddableResourceAssemblerSupport<UsersModel, UsersResource, UsersController> {
    @Autowired
    private UserAddressResourceAssembler userAddressResourceAssembler;

    @Autowired
    public UsersResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, UsersController.class, UsersResource.class);
    }

    @Override
    public Link linkToSingleResource(final UsersModel usersModel) {
        return entityLinks.linkToSingleResource(UsersResource.class, usersModel.getId());
    }

    public UsersResource toDetailedResource(final UsersModel entity) {
        final UsersResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public UsersResource toResource(final UsersModel entity) {
        final UsersResource resource = createResourceWithId(entity.getId(), entity);

        BeanUtils.copyProperties(entity, resource);
        resource.setUsersId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
        if (entity.getUserAddressModels() != null) {
            embeddables.addAll(userAddressResourceAssembler.toEmbeddable(entity.getUserAddressModels()));
        }

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
