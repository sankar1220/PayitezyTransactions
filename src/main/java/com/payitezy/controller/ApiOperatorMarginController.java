package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.ApiOperatorMarginContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.model.ApiOperatorMarginModel;
import com.payitezy.resources.assemblers.ApiOperatorMarginResourceAssembler;
import com.payitezy.resources.hal.ApiOperatorMarginResource;

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
@ExposesResourceFor(value = ApiOperatorMarginResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/apiOperatorMargin", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class ApiOperatorMarginController {
    private static final Logger LOGGER = Logger.getLogger(ApiOperatorMarginController.class);

    private IBusinessDelegate<ApiOperatorMarginModel, ApiOperatorMarginContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ApiOperatorMarginContext> apiOperatorMarginContextFactory;

    @Autowired
    private ApiOperatorMarginResourceAssembler apiOperatorMarginResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiOperatorMarginResource> createApiOperatorMargin(
            @RequestBody final ApiOperatorMarginModel apiOperatorMarginModel) {
        ApiOperatorMarginModel model = businessDelegate.create(apiOperatorMarginModel);
        ApiOperatorMarginResource resource = apiOperatorMarginResourceAssembler.toResource(model);

        return new ResponseEntity<ApiOperatorMarginResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteApiOperatorMargin(@PathVariable(value = "id") final String apiOperatorMarginId) {

        ApiOperatorMarginContext apiOperatorMarginContext = apiOperatorMarginContextFactory.getObject();
        apiOperatorMarginContext.setApiOperatorMarginId(apiOperatorMarginId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(apiOperatorMarginId), apiOperatorMarginContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiOperatorMarginModel> edit(@PathVariable(value = "id") final String apiOperatorMarginId,
            @RequestBody final ApiOperatorMarginModel apiOperatorMarginModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(apiOperatorMarginId), apiOperatorMarginModel);
        return new ResponseEntity<ApiOperatorMarginModel>(apiOperatorMarginModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<ApiOperatorMarginResource>> getAllApiOperatorMargin() {
        ApiOperatorMarginContext apiOperatorMarginContext = apiOperatorMarginContextFactory.getObject();
        apiOperatorMarginContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<ApiOperatorMarginModel> apiOperatorMarginModels = businessDelegate.getCollection(apiOperatorMarginContext);
        final Iterable<ApiOperatorMarginResource> resources = apiOperatorMarginResourceAssembler.toResources(apiOperatorMarginModels);
        return new ResponseEntity<Iterable<ApiOperatorMarginResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiOperatorMarginModel> getApiOperatorMargin(@PathVariable(value = "id") final String apiOperatorMarginId) {
        ApiOperatorMarginContext apiOperatorMarginContext = apiOperatorMarginContextFactory.getObject();
        ApiOperatorMarginModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(apiOperatorMarginId),
                apiOperatorMarginContext);
        return new ResponseEntity<ApiOperatorMarginModel>(model, HttpStatus.OK);
    }

    @Resource(name = "apiOperatorMarginBusinessDelegate")
    public void setApiOperatorMarginBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setApiOperatorMarginObjectFactory(final ObjectFactory<ApiOperatorMarginContext> apiOperatorMarginContextFactory) {
        this.apiOperatorMarginContextFactory = apiOperatorMarginContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
