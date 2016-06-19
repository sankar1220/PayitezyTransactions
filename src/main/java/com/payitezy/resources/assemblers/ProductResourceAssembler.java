package com.payitezy.resources.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.payitezy.apiobjects.SearchProduct;
import com.payitezy.controller.ProductController;
import com.payitezy.resources.hal.ProductResource;



@Service
public class ProductResourceAssembler extends EmbeddableResourceAssemblerSupport<SearchProduct, ProductResource, ProductController>{

   /*@Autowired
   private BookResourceAssembler bookResourceAssembler;*/
   
   @Autowired
   public ProductResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
      super(entityLinks, relProvider, ProductController.class, ProductResource.class);
   }

   @Override
   public Link linkToSingleResource(SearchProduct searchProduct) {
       return entityLinks.linkToSingleResource(ProductResource.class, searchProduct.getProduct_category());
   }
   
   
   @Override
   public ProductResource toResource(SearchProduct entity) {
      final ProductResource resource = createResourceWithId(entity.getProduct_category(), entity);
      // Add (multiple) links to authored books 
     /* for(Book book : entity.getBooks()) {
         resource.add( bookResourceAssembler.linkToSingleResource(book).withRel("authored-books") ); 
      }*/
       
      return resource;
   }

   @Override
   protected ProductResource instantiateResource(SearchProduct entity) {
      return new ProductResource(entity.getProduct_title(),entity.getProduct_lowest_price(),entity.getProduct_link(),entity.getProduct_category(),entity.getProduct_sub_cate(),entity.getProduct_image());
   }
      
}

