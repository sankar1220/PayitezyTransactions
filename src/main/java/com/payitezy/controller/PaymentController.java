package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.PaymentContext;
import com.payitezy.model.PaymentModel;
import com.payitezy.resources.assemblers.PaymentResourceAssembler;
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
@ExposesResourceFor(value = PaymentResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/payment", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class PaymentController {
    private static final Logger LOGGER = Logger.getLogger(PaymentController.class);

    private IBusinessDelegate<PaymentModel, PaymentContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PaymentContext> paymentContextFactory;

    @Autowired
    private PaymentResourceAssembler paymentResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PaymentResource> createPayment(@RequestBody final PaymentModel paymentModel) {
        PaymentModel model = businessDelegate.create(paymentModel);
        PaymentResource resource = paymentResourceAssembler.toResource(model);

        return new ResponseEntity<PaymentResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deletePayment(@PathVariable(value = "id") final String paymentId) {

        PaymentContext paymentContext = paymentContextFactory.getObject();
        paymentContext.setPaymentId(paymentId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(paymentId), paymentContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PaymentModel> edit(@PathVariable(value = "id") final String paymentId,
            @RequestBody final PaymentModel paymentModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(paymentId), paymentModel);
        return new ResponseEntity<PaymentModel>(paymentModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<PaymentResource>> getAllPayment() {
        PaymentContext paymentContext = paymentContextFactory.getObject();
        paymentContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<PaymentModel> paymentModels = businessDelegate.getCollection(paymentContext);
        final Iterable<PaymentResource> resources = paymentResourceAssembler.toResources(paymentModels);
        return new ResponseEntity<Iterable<PaymentResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PaymentModel> getPayment(@PathVariable(value = "id") final String paymentId) {
        PaymentContext paymentContext = paymentContextFactory.getObject();
        PaymentModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(paymentId), paymentContext);
        return new ResponseEntity<PaymentModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "paymentBusinessDelegate")
    public void setPaymentBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setPaymentObjectFactory(final ObjectFactory<PaymentContext> paymentContextFactory) {
        this.paymentContextFactory = paymentContextFactory;
    }
}