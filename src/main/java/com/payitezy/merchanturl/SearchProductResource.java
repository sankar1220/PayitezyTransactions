package com.payitezy.merchanturl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.SearchProduct;


@Component
public class SearchProductResource {
	@Autowired
	private QueryService queryService;
	 
	
	public List<SearchProduct> getSearchProducts(){
		  String apiKey = APIKeys.DATAYUGEKEYS.getSequenceName();
	        String apiUrl = "http://api.datayuge.in/v4/pricecompare/search?apikey="+apiKey+"&product=mobiles";
	        List<SearchProduct> list = new ArrayList<SearchProduct>(0);
	        try {
	            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(apiUrl).getEntity());
	            JSONParser parser = new JSONParser();
	            Object obj = parser.parse(jsonString);
	            JSONObject json = (JSONObject) obj;
	            ObjectMapper mapper = new ObjectMapper();
	          

	             list = mapper.readValue(json.get("data").toString(),
	                    TypeFactory.defaultInstance().constructCollectionType(List.class, SearchProduct.class));
	          
	        }
	        catch (org.apache.http.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        catch (org.json.simple.parser.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return list;
			
	}	
	
	
}
