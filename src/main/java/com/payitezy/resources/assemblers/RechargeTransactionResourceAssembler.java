/**
 *
 */
package com.payitezy.resources.assemblers;

import com.payitezy.controller.RechargeTransactionController;
import com.payitezy.model.RechargeTransactionModel;
import com.payitezy.resources.hal.RechargeTransactionResource;

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

/**
 * @author mohan
 *
 */
@Service
public class RechargeTransactionResourceAssembler extends
EmbeddableResourceAssemblerSupport<RechargeTransactionModel, RechargeTransactionResource, RechargeTransactionController> {

    @Autowired
    public RechargeTransactionResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
        super(entityLinks, relProvider, RechargeTransactionController.class, RechargeTransactionResource.class);
    }

    @Override
    public Link linkToSingleResource(final RechargeTransactionModel rechargeTransactionModel) {
        return entityLinks.linkToSingleResource(RechargeTransactionResource.class, rechargeTransactionModel.getId());
    }

    public RechargeTransactionResource toDetailedResource(final RechargeTransactionModel entity) {
        final RechargeTransactionResource resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    public RechargeTransactionResource toResource(final RechargeTransactionModel entity) {
        final RechargeTransactionResource resource = createResourceWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setRechargeTransactionId(entity.getId());

        final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();

        resource.setEmbeddeds(new Resources<>(embeddables));
        return resource;
    }

}
