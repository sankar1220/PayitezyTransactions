package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.UsersContext;
import com.payitezy.model.UsersModel;
import com.payitezy.resources.assemblers.UsersResourceAssembler;
import com.payitezy.resources.hal.UsersResource;

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
@ExposesResourceFor(value = UsersResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class UsersController {
    private static final Logger LOGGER = Logger.getLogger(UsersController.class);

    private IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UsersContext> usersContextFactory;

    @Autowired
    private UsersResourceAssembler usersResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersResource> createUsers(@RequestBody final UsersModel usersModel) {
        UsersModel model = businessDelegate.create(usersModel);
        UsersResource resource = usersResourceAssembler.toResource(model);

        return new ResponseEntity<UsersResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteUsers(@PathVariable(value = "id") final String usersId) {

        UsersContext usersContext = usersContextFactory.getObject();
        usersContext.setUserId(usersId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(usersId), usersContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsersModel> edit(@PathVariable(value = "id") final String usersId, @RequestBody final UsersModel usersModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(usersId), usersModel);
        return new ResponseEntity<UsersModel>(usersModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<UsersResource>> getAllUsers() {
        UsersContext usersContext = usersContextFactory.getObject();
        usersContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        final Iterable<UsersResource> resources = usersResourceAssembler.toResources(usersModels);
        return new ResponseEntity<Iterable<UsersResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersModel> getUsers(@PathVariable(value = "id") final String usersId) {
        UsersContext usersContext = usersContextFactory.getObject();
        UsersModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(usersId), usersContext);
        return new ResponseEntity<UsersModel>(model, HttpStatus.OK);
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

    @Autowired
    public void setUsersObjectFactory(final ObjectFactory<UsersContext> usersContextFactory) {
        this.usersContextFactory = usersContextFactory;
    }

}
