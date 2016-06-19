package com.payitezy.merchanturl;

import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.FlipkartCategory;
import com.payitezy.apiobjects.FlipkartProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlipkartResources {

    @Autowired
    private QueryService queryService;

    public List<FlipkartProduct> getFlipkartCartProductsUrlByCategory(final String flipkartProductsLink) {
        /*String affiliateId = APIKeys.FLIPKARTAFFILIATEID.getSequenceName();*/
        //	String affiliateBaseUrl = "https://affiliate-api.flipkart.net/affiliate/api/"+affiliateId+".json";
        List<FlipkartProduct> flipkartProducts = new ArrayList<FlipkartProduct>();

        try {
            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponseByMerchantSpecificHeaders(flipkartProductsLink,
                    "FLIPKART").getEntity());
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonString);
            JSONObject json = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) json.get("productInfoList");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject product = (JSONObject) jsonArray.get(i);
                FlipkartProduct flipkartProduct = new FlipkartProduct();
                //	System.out.println(((JSONObject)((JSONObject)(product.get("productBaseInfo"))).get("productIdentifier")).get("productId"));

                flipkartProduct.setId(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productIdentifier")).get(
                        "productId").toString());
                flipkartProduct.setTitle(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get(
                        "title").toString());
                if (((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get("productDescription") != null) {
                    flipkartProduct.setProductDescription(((JSONObject) ((JSONObject) (product.get("productBaseInfo")))
                            .get("productAttributes")).get("productDescription").toString());
                }
                if (((JSONObject) ((JSONObject) product.get("productBaseInfo")).get("productAttributes")).get("imageUrls") != null) {
                    if (((JSONObject) ((JSONObject) ((JSONObject) product.get("productBaseInfo")).get("productAttributes"))
                            .get("imageUrls")).get("200x200") != null) {
                        flipkartProduct.setImageUrl(((JSONObject) ((JSONObject) ((JSONObject) product.get("productBaseInfo"))
                                .get("productAttributes")).get("imageUrls")).get("200x200").toString());
                    }
                }
                flipkartProduct.setMrp(((JSONObject) ((JSONObject) ((JSONObject) product.get("productBaseInfo")).get("productAttributes"))
                        .get("maximumRetailPrice")).get("amount").toString());
                flipkartProduct.setSellingPrice(((JSONObject) ((JSONObject) ((JSONObject) product.get("productBaseInfo"))
                        .get("productAttributes")).get("sellingPrice")).get("amount").toString());
                flipkartProduct.setProductUrl(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get(
                        "productUrl").toString());

                flipkartProduct.setProductBrand(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes"))
                        .get("productBrand").toString());
                if (((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get("inStock") != null) {
                    flipkartProduct.setInStock(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get(
                            "inStock").toString());
                }

                flipkartProduct.setIsAvailabile(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes"))
                        .get("isAvailable").toString());
                if (((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get("cashBack") != null) {
                    flipkartProduct.setCashBack(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes"))
                            .get("cashBack").toString());
                }

                flipkartProduct.setDiscountPercentage(((JSONObject) ((JSONObject) (product.get("productBaseInfo")))
                        .get("productAttributes")).get("discountPercentage").toString());
                flipkartProduct.setColor(((JSONObject) ((JSONObject) (product.get("productBaseInfo"))).get("productAttributes")).get(
                        "color").toString());
                flipkartProducts.add(flipkartProduct);

            }
            //System.out.println(jsonString);
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flipkartProducts;
    }

    public List<FlipkartCategory> getFlipkartCategoryByAffiliate() {
        String affiliateId = APIKeys.FLIPKARTAFFILIATEID.getSequenceName();
        String affiliateBaseUrl = "https://affiliate-api.flipkart.net/affiliate/api/" + affiliateId + ".json";
        List<FlipkartCategory> flipkartCategories = new ArrayList<FlipkartCategory>();
        try {
            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(affiliateBaseUrl).getEntity());

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonString);
            JSONObject json = (JSONObject) obj;

            JSONObject json2 = (JSONObject) ((JSONObject) ((JSONObject) json.get("apiGroups")).get("affiliate")).get("apiListings");

            Iterator iterator = json2.keySet().iterator();
            while (iterator.hasNext()) {
                FlipkartCategory flikartCategory = new FlipkartCategory();
                String categoryName = (String) iterator.next();
                flikartCategory.setCategoryName(((String) iterator.next()).replaceAll("_", " "));
                JSONObject categoryJson = (JSONObject) ((JSONObject) json2.get(categoryName)).get("availableVariants");
                List<String> version_keys = new ArrayList<String>();
                Iterator versionKeyIterator = categoryJson.keySet().iterator();
                while (versionKeyIterator.hasNext()) {
                    version_keys.add((String) versionKeyIterator.next());
                }

                Collections.sort(version_keys, Collections.reverseOrder());
                String categoryLink = (((JSONObject) categoryJson.get(version_keys.get(0))).get("get")).toString();
                flikartCategory.setCategoryLink(categoryLink);
                flipkartCategories.add(flikartCategory);
                //System.out.println(flikartCategory.getCategoryName()+'-'+flikartCategory.getCategoryLink());
            }

        }
        catch (org.apache.http.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flipkartCategories;
    }

}
