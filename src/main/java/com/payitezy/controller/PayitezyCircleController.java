package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.PayitezyCircleContext;
import com.payitezy.model.PayitezyCircleModel;
import com.payitezy.resources.assemblers.PayitezyCircleResourceAssembler;
import com.payitezy.resources.hal.PayitezyCircleResource;

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
@ExposesResourceFor(value = PayitezyCircleResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/payitezyCircle", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class PayitezyCircleController {
    private static final Logger LOGGER = Logger.getLogger(PayitezyCircleController.class);

    private IBusinessDelegate<PayitezyCircleModel, PayitezyCircleContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PayitezyCircleContext> payitezyCircleContextFactory;

    @Autowired
    private PayitezyCircleResourceAssembler payitezyCircleResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PayitezyCircleResource> createPayitezyCircle(@RequestBody final PayitezyCircleModel payitezyCircleModel) {
        PayitezyCircleModel model = businessDelegate.create(payitezyCircleModel);
        PayitezyCircleResource resource = payitezyCircleResourceAssembler.toResource(model);

        return new ResponseEntity<PayitezyCircleResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deletePayitezyCircle(@PathVariable(value = "id") final String payitezyCircleId) {

        PayitezyCircleContext payitezyCircleContext = payitezyCircleContextFactory.getObject();
        payitezyCircleContext.setPayitezyCircleId(payitezyCircleId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(payitezyCircleId), payitezyCircleContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PayitezyCircleModel> edit(@PathVariable(value = "id") final String payitezyCircleId,
            @RequestBody final PayitezyCircleModel payitezyCircleModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(payitezyCircleId), payitezyCircleModel);
        return new ResponseEntity<PayitezyCircleModel>(payitezyCircleModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<PayitezyCircleResource>> getAllPayitezyCircle() {
        PayitezyCircleContext payitezyCircleContext = payitezyCircleContextFactory.getObject();
        payitezyCircleContext.setAll("all");

        Iterable<PayitezyCircleModel> payitezyCircleModels = businessDelegate.getCollection(payitezyCircleContext);
        final Iterable<PayitezyCircleResource> resources = payitezyCircleResourceAssembler.toResources(payitezyCircleModels);
        return new ResponseEntity<Iterable<PayitezyCircleResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PayitezyCircleModel> getPayitezyCircle(@PathVariable(value = "id") final String payitezyCircleId) {
        PayitezyCircleContext payitezyCircleContext = payitezyCircleContextFactory.getObject();
        PayitezyCircleModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(payitezyCircleId), payitezyCircleContext);
        return new ResponseEntity<PayitezyCircleModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "payitezyCircleBusinessDelegate")
    public void setPayitezyCircleBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setPayitezyCircleObjectFactory(final ObjectFactory<PayitezyCircleContext> payitezyCircleContextFactory) {
        this.payitezyCircleContextFactory = payitezyCircleContextFactory;
    }

}
