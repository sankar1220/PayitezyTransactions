package com.payitezy.controller;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.UserAddressContext;
import com.payitezy.model.UserAddressModel;
import com.payitezy.resources.assemblers.UserAddressResourceAssembler;
import com.payitezy.resources.hal.UserAddressResource;

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
@ExposesResourceFor(value = UserAddressResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/userAddress", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class UserAddressController {
    private static final Logger LOGGER = Logger.getLogger(UserAddressController.class);

    private IBusinessDelegate<UserAddressModel, UserAddressContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserAddressContext> userAddressContextFactory;

    @Autowired
    private UserAddressResourceAssembler userAddressResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserAddressResource> createUserAddress(@RequestBody final UserAddressModel userAddressModel) {
        UserAddressModel model = businessDelegate.create(userAddressModel);
        UserAddressResource resource = userAddressResourceAssembler.toResource(model);

        return new ResponseEntity<UserAddressResource>(resource, HttpStatus.CREATED);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "userAddressBusinessDelegate")
    public void setUserAddressBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setUserAddressObjectFactory(final ObjectFactory<UserAddressContext> userAddressContextFactory) {
        this.userAddressContextFactory = userAddressContextFactory;
    }

}
