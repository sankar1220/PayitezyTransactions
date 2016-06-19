package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.TransactionContext;
import com.payitezy.model.TransactionModel;
import com.payitezy.resources.assemblers.TransactionResourceAssembler;
import com.payitezy.resources.hal.TransactionResource;

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
@ExposesResourceFor(value = TransactionResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/transaction", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class TransactionController {
    private static final Logger LOGGER = Logger.getLogger(TransactionController.class);

    private IBusinessDelegate<TransactionModel, TransactionContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<TransactionContext> transactionContextFactory;

    @Autowired
    private TransactionResourceAssembler transactionResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody final TransactionModel transactionModel) {
        TransactionModel model = businessDelegate.create(transactionModel);
        TransactionResource resource = transactionResourceAssembler.toResource(model);

        return new ResponseEntity<TransactionResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteTransaction(@PathVariable(value = "id") final String transactionId) {

        TransactionContext transactionContext = transactionContextFactory.getObject();
        transactionContext.setTransactionId(transactionId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(transactionId), transactionContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TransactionModel> edit(@PathVariable(value = "id") final String transactionId,
            @RequestBody final TransactionModel transactionModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(transactionId), transactionModel);
        return new ResponseEntity<TransactionModel>(transactionModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<TransactionResource>> getAllTransaction() {
        TransactionContext transactionContext = transactionContextFactory.getObject();
        transactionContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<TransactionModel> transactionModels = businessDelegate.getCollection(transactionContext);
        final Iterable<TransactionResource> resources = transactionResourceAssembler.toResources(transactionModels);
        return new ResponseEntity<Iterable<TransactionResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TransactionModel> getTransaction(@PathVariable(value = "id") final String transactionId) {
        TransactionContext transactionContext = transactionContextFactory.getObject();
        TransactionModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(transactionId), transactionContext);
        return new ResponseEntity<TransactionModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory6
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "transactionBusinessDelegate")
    public void setTransactionBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setTransactionObjectFactory(final ObjectFactory<TransactionContext> transactionContextFactory) {
        this.transactionContextFactory = transactionContextFactory;
    }

}
