package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.RechargeTransactionContext;
import com.payitezy.model.RechargeTransactionModel;
import com.payitezy.resources.assemblers.RechargeTransactionResourceAssembler;
import com.payitezy.resources.hal.RechargeTransactionResource;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ExposesResourceFor(value = RechargeTransactionResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/rechargeTransaction", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class RechargeTransactionController {
    private static final Logger LOGGER = Logger.getLogger(RechargeTransactionController.class);

    private IBusinessDelegate<RechargeTransactionModel, RechargeTransactionContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<RechargeTransactionContext> rechargeTransactionContextFactory;

    @Autowired
    private RechargeTransactionResourceAssembler rechargeTransactionResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<RechargeTransactionResource> createRechargeTransaction(
            @RequestBody final RechargeTransactionModel rechargeTransactionModel) {
        RechargeTransactionModel model = businessDelegate.create(rechargeTransactionModel);
        RechargeTransactionResource resource = rechargeTransactionResourceAssembler.toResource(model);
        return new ResponseEntity<RechargeTransactionResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteRechargeTransaction(@PathVariable(value = "id") final String rechargeTransactionId) {

        RechargeTransactionContext rechargeTransactionContext = rechargeTransactionContextFactory.getObject();
        rechargeTransactionContext.setRechargeTransactionId(rechargeTransactionId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(rechargeTransactionId), rechargeTransactionContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RechargeTransactionModel> edit(@PathVariable(value = "id") final String rechargeTransactionId,
            @RequestBody final RechargeTransactionModel rechargeTransactionModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(rechargeTransactionId), rechargeTransactionModel);
        return new ResponseEntity<RechargeTransactionModel>(rechargeTransactionModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<RechargeTransactionResource>> getAllRechargeTransaction() {
        RechargeTransactionContext rechargeTransactionContext = rechargeTransactionContextFactory.getObject();
        rechargeTransactionContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<RechargeTransactionModel> rechargeTransactionModels = businessDelegate.getCollection(rechargeTransactionContext);
        final Iterable<RechargeTransactionResource> resources = rechargeTransactionResourceAssembler.toResources(rechargeTransactionModels);
        return new ResponseEntity<Iterable<RechargeTransactionResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<RechargeTransactionModel> getRechargeTransaction(@PathVariable(value = "id") final String rechargeTransactionId) {
        RechargeTransactionContext rechargeTransactionContext = rechargeTransactionContextFactory.getObject();
        RechargeTransactionModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(rechargeTransactionId),
                rechargeTransactionContext);
        return new ResponseEntity<RechargeTransactionModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "rechargeTransactionBusinessDelegate")
    public void setRechargeTransactionBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setRechargeTransactionObjectFactory(final ObjectFactory<RechargeTransactionContext> rechargeTransactionContextFactory) {
        this.rechargeTransactionContextFactory = rechargeTransactionContextFactory;
    }

}
