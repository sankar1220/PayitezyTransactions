package com.payitezy.controller;

import com.payitezy.apiobjects.SearchProduct;
import com.payitezy.merchanturl.SearchProductResource;
import com.payitezy.resources.assemblers.ProductResourceAssembler;
import com.payitezy.resources.hal.ProductResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@ExposesResourceFor(ProductResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class ProductController {
    @Autowired
    private SearchProductResource searchProductResource;
    @Autowired
    private ProductResourceAssembler productResourceAssembler;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<ProductResource>> getProducts() {
        Iterable<SearchProduct> searchProducts = searchProductResource.getSearchProducts();
        Iterable<ProductResource> response = productResourceAssembler.toResources(searchProducts);
        return ResponseEntity.ok(response);
    }

}
