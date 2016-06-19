package com.payitezy.resources.assemblers;

import com.payitezy.controller.UserAddressController;
import com.payitezy.model.UserAddressModel;
import com.payitezy.resources.hal.UserAddressResource;

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
public class UserAddressResourceAssembler extends
        EmbeddableResourceAssemblerSupport<UserAddressModel, UserAddressResource, UserAddressController> {

    @Autowired
    public UserAddressResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, UserAddressController.class, UserAddressResource.class);
    }

    @Override
    public Link linkToSingleResource(final UserAddressModel userAddressModel) {
        return entityLinks.linkToSingleResource(UserAddressResource.class, userAddressModel.getId());
    }

    public UserAddressResource toDetailedResource(final UserAddressModel entity) {
        final UserAddressResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public UserAddressResource toResource(final UserAddressModel entity) {
        final UserAddressResource resource = createResourceWithId(entity.getId(), entity);

        BeanUtils.copyProperties(entity, resource);
        /*     resource.setUsersId(entity.getUsersId());*/
        resource.setUserAddressId(entity.getId());
        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
        /* if (entity.getUserAddressModels() != null) {
                embeddables.addAll(userAddressResourceAssembler.toEmbeddable(entity.getUserAddressModels()));
            }*/

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
