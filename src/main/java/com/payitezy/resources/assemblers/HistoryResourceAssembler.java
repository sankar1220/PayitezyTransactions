

package com.payitezy.resources.assemblers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.payitezy.controller.HistoryController;
import com.payitezy.model.HistoryModel;
import com.payitezy.resources.hal.HistoryResource;


@Service
public class HistoryResourceAssembler extends EmbeddableResourceAssemblerSupport<HistoryModel, HistoryResource, HistoryController>{

	@Autowired
	public HistoryResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider){
		super(entityLinks, relProvider, HistoryController.class, HistoryResource.class);
	}
	
	@Override
	public Link linkToSingleResource(final HistoryModel historyModel){
		return entityLinks.linkToSingleResource(HistoryResource.class, historyModel.getId());
	}
	
	
	 public HistoryResource toDetailedResource(final HistoryModel entity){
		 final HistoryResource resource = createResourceWithId(entity.getId(), entity);
		 	 return resource;
	 }
	 
	 public HistoryResource toResource(final HistoryModel entity){
		 final HistoryResource resource = createResourceWithId(entity.getId(),entity);
		 BeanUtils.copyProperties(entity, resource);
		/* resource.setNumber(entity.getNumber());*/
		 return resource;
	 }
}
