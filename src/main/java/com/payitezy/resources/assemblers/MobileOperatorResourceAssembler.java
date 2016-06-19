package com.payitezy.resources.assemblers;


import com.payitezy.controller.MobileOperatorController;
import com.payitezy.model.MobileOperatorModel;

import com.payitezy.resources.hal.MobileOperatorResource;

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
public class MobileOperatorResourceAssembler extends EmbeddableResourceAssemblerSupport<MobileOperatorModel, MobileOperatorResource, MobileOperatorController> {

    @Autowired
    public MobileOperatorResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, MobileOperatorController.class, MobileOperatorResource.class);
    }

    @Override
    public Link linkToSingleResource(final MobileOperatorModel mobileOperatorModel) {
        return entityLinks.linkToSingleResource(MobileOperatorResource.class, mobileOperatorModel.getOperator());
    }

    public MobileOperatorResource toDetailedResource(final MobileOperatorModel entity) {
        final MobileOperatorResource resource = createResourceWithId(entity.getOperator(), entity);

        return resource;
    }

    @Override
    public MobileOperatorResource toResource(final MobileOperatorModel entity) {
        final MobileOperatorResource resource = createResourceWithId(entity.getOperator(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setOperator(entity.getOperator());
        // Add (multiple) links to authored books
        /*resource.add(relProvider.);*/
        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
        /* if(entity.getTransactionsModels()!=null){
           embeddables.addAll( transactionResourceAssembler.toEmbeddable(entity.getTransactionsModels()));
         }*/
        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }
    
    

}
