package com.payitezy.merchanturl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.SnapdealCategory;
import com.payitezy.apiobjects.SnapdealProduct;
@Component
public class SnapdealResources {
	@Autowired
	private QueryService queryService;
	public List<SnapdealCategory> getSnapdealCategoryUrlByAffiliate(){
		String affiliateId = APIKeys.SNAPDEALAFFILIATEID.getSequenceName();
		String affiliateBaseUrl = "http://affiliate-feeds.snapdeal.com/feed/"+affiliateId+".json";
		List<SnapdealCategory> snapdealCategories = new ArrayList<SnapdealCategory>();
		try {
			String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(affiliateBaseUrl).getEntity());
			
			JSONParser parser  = new JSONParser();
			Object obj = parser.parse(jsonString);
			JSONObject json = (JSONObject) obj;
			
			JSONObject json2 = (JSONObject)((JSONObject)((JSONObject)json.get("apiGroups")).get("Affiliate")).get("listingsAvailable");
			
			Iterator iterator = json2.keySet().iterator();
			while(iterator.hasNext()){
				SnapdealCategory snapdealCategory = new SnapdealCategory();
				String categoryName = (String) iterator.next();
				snapdealCategory.setCategoryName(categoryName.replaceAll("_", " "));
				JSONObject categoryJson = (JSONObject)((JSONObject) json2.get(categoryName)).get("listingVersions");
				List<String> version_keys = new ArrayList<String>();
				Iterator versionKeyIterator = categoryJson.keySet().iterator();
				while(versionKeyIterator.hasNext()){
					version_keys.add((String)versionKeyIterator.next());
				}
				
				Collections.sort(version_keys, Collections.reverseOrder());
				String categoryLink =  (((JSONObject) categoryJson.get(version_keys.get(0))).get("get")).toString();
				snapdealCategory.setCategoryLink(categoryLink);
				snapdealCategories.add(snapdealCategory);
				System.out.println(snapdealCategory.getCategoryName()+'-'+snapdealCategory.getCategoryLink());
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return snapdealCategories;
	}
	
	
	public List<SnapdealProduct> getSnapdealProductsByCategoryUrl(String snapdealProductsLink){
		List<SnapdealProduct> snapdealProducts = new ArrayList<SnapdealProduct>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponseByMerchantSpecificHeaders(snapdealProductsLink, "SNAPDEAL").getEntity());
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonString);
			JSONObject json =(JSONObject) obj;
			if(json.get("products")!=null){
			snapdealProducts = mapper.readValue(json.get("products").toString(),
					 TypeFactory.defaultInstance().constructCollectionType(List.class,  
							 SnapdealProduct.class));
			}
			
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  snapdealProducts;
	}
}
