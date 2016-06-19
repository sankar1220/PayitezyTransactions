package com.payitezy.thymeleaf;

//import java.io.BufferedReader;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.*;
import com.payitezy.domain.PayitezyCircle;
import com.payitezy.domain.PayitezyOperator;
import com.payitezy.merchanturl.FlipkartResources;
import com.payitezy.merchanturl.SnapdealResources;
import com.payitezy.service.IPayitezyCircleService;
import com.payitezy.service.IPayitezyOperatorService;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
//import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

@Controller
public class PayitezyThymeLeafController {
    @Autowired
    private FlipkartResources flipkartResources;
    @Autowired
    private SnapdealResources snapdealResources;
    @Autowired
    private QueryService queryService;
    @Autowired
    private IPayitezyOperatorService payitezyOperatorService;
    @Autowired
    private IPayitezyCircleService payitezyCircleService;

    @RequestMapping(value = "/merchant/flipkart", method = RequestMethod.GET)
    public String getFlipkartCategories(final Model model) {

        List<FlipkartCategory> flipkartCategories = flipkartResources.getFlipkartCategoryByAffiliate();

        model.addAttribute("flipkartCategories", flipkartCategories);

        return "FlipkartHomePage";
    }

    @RequestMapping(value = "/products/flipkart/{categoryName}", method = RequestMethod.GET)
    public String getFlipkartProductsByCategory(final Model model, @PathVariable(value = "categoryName") final String categoryName,
            @RequestParam(value = "link") final String flipkartProductsLink) {
        List<FlipkartCategory> flipkartCategories = flipkartResources.getFlipkartCategoryByAffiliate();
        List<FlipkartProduct> flipkartProducts = flipkartResources.getFlipkartCartProductsUrlByCategory(flipkartProductsLink);
        model.addAttribute("flipkartProducts", flipkartProducts);
        model.addAttribute("flipkartCategories", flipkartCategories);

        return "FlipkartProductsPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(final Model model) {

        return "LoginPage";
    }

    @RequestMapping(value = "/redirecttoproduct", method = RequestMethod.GET)
    public String getMerchantProductRedirectionPage(final Model model, @RequestParam(value = "next") final String nextUrl,
            @RequestParam(value = "dest") final String destination, @RequestParam(value = "affId") final String affliateId) {

        return "RedirectPage";

    }

    @RequestMapping(value = "/redirectto", method = RequestMethod.GET)
    public String getMerchantRedirectionPage(final Model model, @RequestParam(value = "next") final String nextUrl,
            @RequestParam(value = "dest") final String destination) {

        return "RedirectPage";

    }

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public String getMerchantSpecificPage(final Model model, @RequestParam(value = "name") final String merchantName) {

        return "MerchantPage";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getMerchantSpecificPage(@RequestParam(value = "searchkey") final String searchkey, final Model model) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        /*
         * HttpGet getRequest = new HttpGet(
         * "http://api.datayuge.in/v4/pricecompare/search?apikey=aZciW2VAYLi3N6NkSUA3qRSBnyGt1A0A&product="
         * +searchkey);
         */
        String apiKeyString = APIKeys.DATAYUGEKEYS.getSequenceName().toString();
        HttpGet getRequest = new HttpGet("http://api.datayuge.in/v4/pricecompare/search?apikey=" + apiKeyString + "&product=" + searchkey);
        getRequest.addHeader("accept", "application/json");

        HttpResponse response;
        try {
            response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            ObjectMapper mapper = new ObjectMapper();

            System.out.println(response.getEntity().getContent());
            String json_string = EntityUtils.toString(response.getEntity());

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json_string);

            final JSONObject json = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) json.get("data");

            List<SearchProduct> list = mapper.readValue(json.get("data").toString(),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, SearchProduct.class));
            model.addAttribute("searchProducts", list);

        }
        catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "ItemsPage";
    }

    @RequestMapping(value = "/rechargePage", method = RequestMethod.GET)
    public String getMobileRechargePage(final Model model) {

        List<PayitezyOperator> payitezyPrepaidOperators = payitezyOperatorService.getOperatorByType("PREPAID");
        List<PayitezyOperator> payitezyPostpaidOperators = payitezyOperatorService.getOperatorByType("POSTPAID");

        List<PayitezyCircle> payitezyCircles = payitezyCircleService.getAll();
        model.addAttribute("payitezyPrepaidOperators", payitezyPrepaidOperators);
        model.addAttribute("payitezyPostpaidOperators", payitezyPostpaidOperators);
        model.addAttribute("payitezyCircles", payitezyCircles);
        return "MobileRechargesMainPage";
    }

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public String getPaymentsPage(final String model) {

        return "PaymentsMainPage";
    }

    @RequestMapping(value = "/searchresults", method = RequestMethod.GET)
    public String getSearchResults(@RequestParam(value = "searchkey") final String searchkey, final Model model) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        /*
         * HttpGet getRequest = new HttpGet(
         * "http://api.datayuge.in/v4/pricecompare/search?apikey=aZciW2VAYLi3N6NkSUA3qRSBnyGt1A0A&product="
         * +searchkey);
         */
        String apiKeyString = APIKeys.DATAYUGEKEYS.getSequenceName().toString();
        HttpGet getRequest = new HttpGet("http://api.datayuge.in/v4/pricecompare/search?apikey=" + apiKeyString + "&product=" + searchkey);
        getRequest.addHeader("accept", "application/json");

        HttpResponse response;
        try {
            response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("get Error");
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            ObjectMapper mapper = new ObjectMapper();

            System.out.println(response.getEntity().getContent());
            String json_string = EntityUtils.toString(response.getEntity());
            System.out.println(json_string);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json_string);

            final JSONObject json = (JSONObject) obj;
            System.out.println(json.get("data"));
            JSONArray jsonArray = (JSONArray) json.get("data");

            List<SearchProduct> list = mapper.readValue(json.get("data").toString(),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, SearchProduct.class));
            model.addAttribute("searchProducts", list);

        }
        catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "fragments/ProductSearchResultsFragment::SearchProductDivFragment";
    }

    @RequestMapping(value = "/product/{productName}", method = RequestMethod.GET)
    public String getSingleProduct(final Model model, @PathVariable(value = "productName") final String productName,
            @RequestParam(value = "next") final String productLink) {

        model.addAttribute("apiKey", APIKeys.DATAYUGEKEYS);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String apiKeyString = APIKeys.DATAYUGEKEYS.getSequenceName().toString();
        HttpGet getRequest = new HttpGet(productLink + "&apikey=" + apiKeyString);
        getRequest.addHeader("accept", "application/json");

        HttpResponse response;

        try {
            response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());

            }
            ObjectMapper mapper = new ObjectMapper();
            // System.out.println(response.getEntity().getContent());
            String json_string = EntityUtils.toString(response.getEntity());
            // System.out.println(json_string);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json_string);
            final JSONObject json = (JSONObject) obj;

            List<ProductDetails> productDetails = mapper.readValue(json.get("productDetails").toString(), TypeFactory.defaultInstance()
                    .constructCollectionType(List.class, ProductDetails.class));
            model.addAttribute("product", productDetails);
            List<ProductMerchantDetails> productMerchants = new ArrayList<ProductMerchantDetails>(0);
            if (json.get("data") != null) {
                productMerchants = mapper.readValue(json.get("data").toString(),
                        TypeFactory.defaultInstance().constructCollectionType(List.class, ProductMerchantDetails.class));

            }
            List<ProductSpecification> productSpecifications = new ArrayList<ProductSpecification>(0);
            if (json.get("specs") != null) {
                productSpecifications = mapper.readValue(json.get("specs").toString(), TypeFactory.defaultInstance()
                        .constructCollectionType(List.class, ProductSpecification.class));
            }
            /*
             * java.util.Collections.sort(productMerchants,new
             * Comparator<ProductMerchantDetails>() { public int
             * compare(ProductMerchantDetails a,ProductMerchantDetails b) {
             * if(a.
             * getProduct_price_after().compareTo(b.getProduct_price_after())>0)
             * return 1; else
             * if(a.getProduct_price_after().compareTo(b.getProduct_price_after
             * ())<0) return -1; else return 0; } public boolean equals(Object
             * a) { return false; } }); for(ProductMerchantDetails
             * pmd:productMerchants){
             * System.out.println(pmd.getProduct_price_after()); }
             */
            model.addAttribute("productMerchants", productMerchants);
            model.addAttribute("productSpecifications", productSpecifications);
            /*
             * if(productMerchants==null ){ productMerchants = new
             * ArrayList<ProductMerchantDetails>(); }
             */

        }
        catch (ClientProtocolException e) {
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

        return "SingleProductPage";
    }

    @RequestMapping(value = "/merchant/snapdeal", method = RequestMethod.GET)
    public String getSnapDealCategories(final Model model) {

        List<SnapdealCategory> snapdealCategories = snapdealResources.getSnapdealCategoryUrlByAffiliate();
        model.addAttribute("snapdealCategories", snapdealCategories);

        return "SnapdealHomePage";
    }

    @RequestMapping(value = "/products/snapdeal/{categoryName}", method = RequestMethod.GET)
    public String getSnapdealProductsByCategory(final Model model, @PathVariable(value = "categoryName") final String categoryName,
            @RequestParam(value = "link") final String snapdealProductsLink) {
        List<SnapdealProduct> snapdealProducts = snapdealResources.getSnapdealProductsByCategoryUrl(snapdealProductsLink);

        List<SnapdealCategory> snapdealCategories = snapdealResources.getSnapdealCategoryUrlByAffiliate();
        model.addAttribute("snapdealProducts", snapdealProducts);
        model.addAttribute("snapdealCategories", snapdealCategories);
        // model.addAttribute("nextUrl", (String)json.get("nextUrl"));

        return "SnapdealProductsPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome(@RequestParam(value = "name", required = false, defaultValue = "World") final String name, final Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
