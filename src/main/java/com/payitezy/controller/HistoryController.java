package com.payitezy.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.HistoryContext;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.MerchantContext;
import com.payitezy.model.HistoryModel;
import com.payitezy.model.MerchantModel;
import com.payitezy.resources.assemblers.HistoryResourceAssembler;
import com.payitezy.resources.assemblers.MerchantResourceAssembler;
import com.payitezy.resources.hal.HistoryResource;
import com.payitezy.resources.hal.MerchantResource;

@RestController
@ExposesResourceFor(value = HistoryResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
@RequestMapping(value = "/history", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
public class HistoryController {
    private static final Logger LOGGER = Logger.getLogger(HistoryController.class);

    private IBusinessDelegate<HistoryModel, HistoryContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<HistoryContext> historyContextFactory;

    @Autowired
    private HistoryResourceAssembler historyResourceAssembler;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<HistoryResource> createHistory(@RequestBody final HistoryModel historyModel) {
    	HistoryModel model = businessDelegate.create(historyModel);
    	HistoryResource resource = historyResourceAssembler.toResource(model);
        return new ResponseEntity<HistoryResource>(resource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteHistory(@PathVariable(value = "id") final String historyId) {

    	HistoryContext historyContext = historyContextFactory.getObject();
    	historyContext.setHistoryId(historyId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(historyId), historyContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<HistoryModel> edit(@PathVariable(value = "id") final String historyId,
            @RequestBody final HistoryModel historyModel) {
    	HistoryContext historyContext = new HistoryContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(historyId), historyModel);
        return new ResponseEntity<HistoryModel>(historyModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<Iterable<HistoryResource>> getAllHistory() {
    	HistoryContext historyContext = historyContextFactory.getObject();
    	historyContext.setAll("all");
        /* Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        usersResourceAssembler.toResources(usersModels);*/
        Iterable<HistoryModel> historyModels = businessDelegate.getCollection(historyContext);
        final Iterable<HistoryResource> resources = historyResourceAssembler.toResources(historyModels);
        return new ResponseEntity<Iterable<HistoryResource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<HistoryModel> getHistory(@PathVariable(value = "id") final String historyId) {
    	HistoryContext historyContext = historyContextFactory.getObject();
    	HistoryModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(historyId), historyContext);
        return new ResponseEntity<HistoryModel>(model, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "historyBusinessDelegate")
    public void setHistoryBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setHistoryObjectFactory(final ObjectFactory<HistoryContext> historyContextFactory) {
        this.historyContextFactory = historyContextFactory;
    }

}
