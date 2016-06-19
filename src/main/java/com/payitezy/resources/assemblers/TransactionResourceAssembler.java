package com.payitezy.resources.assemblers;

import com.payitezy.controller.TransactionController;
import com.payitezy.model.TransactionModel;
import com.payitezy.resources.hal.TransactionResource;

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
public class TransactionResourceAssembler extends
EmbeddableResourceAssemblerSupport<TransactionModel, TransactionResource, TransactionController> {

    @Autowired
    public TransactionResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, TransactionController.class, TransactionResource.class);
    }

    @Override
    public Link linkToSingleResource(final TransactionModel transactionModel) {
        return entityLinks.linkToSingleResource(TransactionResource.class, transactionModel.getId());
    }

    public TransactionResource toDetailedResource(final TransactionModel entity) {
        final TransactionResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public TransactionResource toResource(final TransactionModel entity) {
        final TransactionResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setTransactionId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
