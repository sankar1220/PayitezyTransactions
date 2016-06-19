package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.ApiCircleContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.model.ApiCircleModel;
import com.payitezy.resources.assemblers.ApiCircleResourceAssembler;
import com.payitezy.resources.hal.ApiCircleResource;
import com.payitezy.resources.hal.ApiDetailsResource;

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
@ExposesResourceFor(value = ApiDetailsResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/apiCircle", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class ApiCircleController {
    private static final Logger LOGGER = Logger.getLogger(ApiCircleController.class);

    private IBusinessDelegate<ApiCircleModel, ApiCircleContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ApiCircleContext> apiCircleContextFactory;

    @Autowired
    private ApiCircleResourceAssembler apiCircleResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiCircleResource> createApiDetails(@RequestBody final ApiCircleModel apiCircleModel) {
        ApiCircleModel model = businessDelegate.create(apiCircleModel);
        ApiCircleResource resource = apiCircleResourceAssembler.toResource(model);

        return new ResponseEntity<ApiCircleResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteApiCircle(@PathVariable(value = "id") final String apiCircleId) {

        ApiCircleContext apiCircleContext = apiCircleContextFactory.getObject();
        apiCircleContext.setApiCircleId(apiCircleId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(apiCircleId), apiCircleContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiCircleModel> edit(@PathVariable(value = "id") final String apiCircleId,
            @RequestBody final ApiCircleModel apiCircleModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(apiCircleId), apiCircleModel);
        return new ResponseEntity<ApiCircleModel>(apiCircleModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<ApiCircleResource>> getAllApiDetails() {
        ApiCircleContext apiCircleContext = apiCircleContextFactory.getObject();
        apiCircleContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<ApiCircleModel> apiCircleModels = businessDelegate.getCollection(apiCircleContext);
        final Iterable<ApiCircleResource> resources = apiCircleResourceAssembler.toResources(apiCircleModels);
        return new ResponseEntity<Iterable<ApiCircleResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiCircleModel> getApiDetails(@PathVariable(value = "id") final String apiCircleId) {
        ApiCircleContext apiCircleContext = apiCircleContextFactory.getObject();
        ApiCircleModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(apiCircleId), apiCircleContext);
        return new ResponseEntity<ApiCircleModel>(model, HttpStatus.OK);
    }

    @Resource(name = "apiCircleBusinessDelegate")
    public void setApiCircleBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setApiCircleObjectFactory(final ObjectFactory<ApiCircleContext> apiCircleContextFactory) {
        this.apiCircleContextFactory = apiCircleContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
