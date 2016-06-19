package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.ApiKeysContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.model.ApiKeysModel;
import com.payitezy.resources.assemblers.ApiKeysResourceAssembler;
import com.payitezy.resources.hal.ApiKeysResource;

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
@ExposesResourceFor(value = ApiKeysResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/apiKeys", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class ApiKeysController {
    private static final Logger LOGGER = Logger.getLogger(ApiKeysController.class);

    private IBusinessDelegate<ApiKeysModel, ApiKeysContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ApiKeysContext> apiKeysContextFactory;

    @Autowired
    private ApiKeysResourceAssembler apiKeysResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiKeysResource> createApiKeys(@RequestBody final ApiKeysModel apiKeysModel) {
        ApiKeysModel model = businessDelegate.create(apiKeysModel);
        ApiKeysResource resource = apiKeysResourceAssembler.toResource(model);

        return new ResponseEntity<ApiKeysResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteApiKeys(@PathVariable(value = "id") final String apiKeysId) {

        ApiKeysContext apiKeysContext = apiKeysContextFactory.getObject();
        apiKeysContext.setApiKeysId(apiKeysId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(apiKeysId), apiKeysContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiKeysModel> edit(@PathVariable(value = "id") final String apiKeysId,
            @RequestBody final ApiKeysModel apiKeysModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(apiKeysId), apiKeysModel);
        return new ResponseEntity<ApiKeysModel>(apiKeysModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiKeysModel> getApiKeys(@PathVariable(value = "id") final String apiKeysId) {
        ApiKeysContext apiKeysContext = apiKeysContextFactory.getObject();
        ApiKeysModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(apiKeysId), apiKeysContext);
        return new ResponseEntity<ApiKeysModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<ApiKeysResource>> getAllApiKeys() {
        ApiKeysContext apiKeysContext = apiKeysContextFactory.getObject();
        apiKeysContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<ApiKeysModel> apiKeysModels = businessDelegate.getCollection(apiKeysContext);
        final Iterable<ApiKeysResource> resources = apiKeysResourceAssembler.toResources(apiKeysModels);
        return new ResponseEntity<Iterable<ApiKeysResource>>(resources, HttpStatus.OK);
    }

    @Autowired
    public void setApiKeysObjectFactory(final ObjectFactory<ApiKeysContext> apiKeysContextFactory) {
        this.apiKeysContextFactory = apiKeysContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "usersBusinessDelegate")
    public void setUsersBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

}
