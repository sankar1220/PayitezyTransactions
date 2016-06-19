package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.PayitezyOperatorContext;
import com.payitezy.businessdelegate.service.PaymentContext;
import com.payitezy.model.PayitezyOperatorModel;
import com.payitezy.model.PaymentModel;
import com.payitezy.resources.assemblers.PayitezyOperatorResourceAssembler;
import com.payitezy.resources.assemblers.PaymentResourceAssembler;
import com.payitezy.resources.hal.PayitezyOperatorResource;
import com.payitezy.resources.hal.PaymentResource;

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
@ExposesResourceFor(value = PayitezyOperatorResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/payitezyOperator", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class PayitezyOperatorController {
    private static final Logger LOGGER = Logger.getLogger(PayitezyOperatorController.class);

    private IBusinessDelegate<PayitezyOperatorModel, PayitezyOperatorContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PayitezyOperatorContext> payitezyOperatorContextFactory;

    @Autowired
    private PayitezyOperatorResourceAssembler payitezyOperatorResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PayitezyOperatorResource> createPayitezyOperator(@RequestBody final PayitezyOperatorModel payitezyOperatorModel) {
    	PayitezyOperatorModel model = businessDelegate.create(payitezyOperatorModel);
    	PayitezyOperatorResource resource = payitezyOperatorResourceAssembler.toResource(model);

        return new ResponseEntity<PayitezyOperatorResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deletePayitezyOperator(@PathVariable(value = "id") final String payitezyOperatorId) {

    	PayitezyOperatorContext payitezyOperatorContext = payitezyOperatorContextFactory.getObject();
    	payitezyOperatorContext.setPayitezyOperatorId(payitezyOperatorId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(payitezyOperatorId), payitezyOperatorContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PayitezyOperatorModel> edit(@PathVariable(value = "id") final String payitezyOperatorId,
            @RequestBody final PayitezyOperatorModel payitezyOperatorModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(payitezyOperatorId), payitezyOperatorModel);
        return new ResponseEntity<PayitezyOperatorModel>(payitezyOperatorModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<PayitezyOperatorResource>> getAllPayitezyOperator() {
    	PayitezyOperatorContext payitezyOperatorContext = payitezyOperatorContextFactory.getObject();
    	payitezyOperatorContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<PayitezyOperatorModel> payitezyOperatorModels = businessDelegate.getCollection(payitezyOperatorContext);
        final Iterable<PayitezyOperatorResource> resources = payitezyOperatorResourceAssembler.toResources(payitezyOperatorModels);
        return new ResponseEntity<Iterable<PayitezyOperatorResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PayitezyOperatorModel> getPayitezyOperator(@PathVariable(value = "id") final String payitezyOperatorId) {
    	PayitezyOperatorContext payitezyOperatorContext = payitezyOperatorContextFactory.getObject();
    	PayitezyOperatorModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(payitezyOperatorId), payitezyOperatorContext);
        return new ResponseEntity<PayitezyOperatorModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "payitezyOperatorBusinessDelegate")
    public void setPayitezyOperatorBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setPayitezyOperatorObjectFactory(final ObjectFactory<PayitezyOperatorContext> payitezyOperatorContextFactory) {
        this.payitezyOperatorContextFactory = payitezyOperatorContextFactory;
    }
}