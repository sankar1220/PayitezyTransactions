package com.payitezy.apiobjects;



// Encapsulate the logic to get the resource ID out of the domain entity
public abstract class CustomObjectIdFactory {

   public static String getId(SearchProduct searchProduct) {
      return searchProduct.getProduct_link();
   }
   
 
}
