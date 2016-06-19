package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.ApiDetailsContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.model.ApiDetailsModel;
import com.payitezy.resources.assemblers.ApiDetailsResourceAssembler;
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
@RequestMapping(value = "/apiDetails", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class ApiDetailsController {
    private static final Logger LOGGER = Logger.getLogger(ApiDetailsController.class);

    private IBusinessDelegate<ApiDetailsModel, ApiDetailsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ApiDetailsContext> apiDetailsContextFactory;

    @Autowired
    private ApiDetailsResourceAssembler apiDetailsResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiDetailsResource> createApiDetails(@RequestBody final ApiDetailsModel apiDetailsModel) {
        ApiDetailsModel model = businessDelegate.create(apiDetailsModel);
        ApiDetailsResource resource = apiDetailsResourceAssembler.toResource(model);

        return new ResponseEntity<ApiDetailsResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteApiDetails(@PathVariable(value = "id") final String apiDetailsId) {

        ApiDetailsContext apiDetailsContext = apiDetailsContextFactory.getObject();
        apiDetailsContext.setApiDetailsId(apiDetailsId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(apiDetailsId), apiDetailsContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiDetailsModel> edit(@PathVariable(value = "id") final String apiDetailsId,
            @RequestBody final ApiDetailsModel apiDetailsModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(apiDetailsId), apiDetailsModel);
        return new ResponseEntity<ApiDetailsModel>(apiDetailsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<ApiDetailsResource>> getAllApiDetails() {
        ApiDetailsContext apiDetailsContext = apiDetailsContextFactory.getObject();
        apiDetailsContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<ApiDetailsModel> apiDetailsModels = businessDelegate.getCollection(apiDetailsContext);
        final Iterable<ApiDetailsResource> resources = apiDetailsResourceAssembler.toResources(apiDetailsModels);
        return new ResponseEntity<Iterable<ApiDetailsResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ApiDetailsModel> getApiDetails(@PathVariable(value = "id") final String apiDetailsId) {
        ApiDetailsContext apiDetailsContext = apiDetailsContextFactory.getObject();
        ApiDetailsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(apiDetailsId), apiDetailsContext);
        return new ResponseEntity<ApiDetailsModel>(model, HttpStatus.OK);
    }

    @Resource(name = "apiDetailsBusinessDelegate")
    public void setApiDetailsBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setApiDetailsObjectFactory(final ObjectFactory<ApiDetailsContext> apiDetailsContextFactory) {
        this.apiDetailsContextFactory = apiDetailsContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
