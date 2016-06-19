package com.payitezy;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

@Component
public class QueryService {

    public HttpResponse sendHttpRequestAndResponse(final String url) {

        HttpResponse response = null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader("accept", "application/json");

        try {
            response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("get Error");
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());

            }

        }
        catch (ClientProtocolException e) {

            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        return response;
    }

    public HttpResponse sendHttpRequestAndResponseByMerchantSpecificHeaders(final String url, final String merchant) {

        HttpResponse response = null;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);

        switch (merchant) {
            case "FLIPKART":
                getRequest.addHeader("accept", "application/json");
                getRequest.addHeader("Fk-Affiliate-Id", APIKeys.FLIPKARTAFFILIATEID.getSequenceName());
                getRequest.addHeader("Fk-Affiliate-Token", APIKeys.FLIPKARTAFFILIATETOKEN.getSequenceName());
                break;
            case "SNAPDEAL":
                getRequest.addHeader("accept", "application/json");
                getRequest.addHeader("Snapdeal-Affiliate-Id", APIKeys.SNAPDEALAFFILIATEID.getSequenceName());
                getRequest.addHeader("Snapdeal-Token-Id", APIKeys.SNAPDEALAFFILIATETOKEN.getSequenceName());
                break;
            case "AMAZON":
                getRequest.addHeader("accept", "text/xml");

        }

        try {
            response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("get Error");
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());

            }

        }
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

}
