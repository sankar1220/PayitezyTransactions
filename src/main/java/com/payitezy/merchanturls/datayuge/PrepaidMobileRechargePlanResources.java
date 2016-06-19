package com.payitezy.merchanturls.datayuge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.PrepaidMobileRechargePlans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrepaidMobileRechargePlanResources {

    @Autowired
    private QueryService queryService;
    private String dataYuge = APIKeys.DATAYUGEKEYS.getSequenceName();

    public List<PrepaidMobileRechargePlans> getPrepaidMobileRechargePlansByNumber(final String circleId, final String operatorId,
            final String limit) {
        // TODO Auto-generated method stub

        //PrepaidMobileRechargePlans prepaidMobileRechargePlans = new PrepaidMobileRechargePlans();
        String mobileRechargePlans = "http://api.datayuge.in/v4/rechargeplans/?apikey=" + dataYuge + "&operatorid=" + operatorId
                + "&circleid=" + circleId;
        List<PrepaidMobileRechargePlans> prepaidMobileRechargePlans = new ArrayList<PrepaidMobileRechargePlans>(0);
        try {
            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(mobileRechargePlans).getEntity());
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(jsonString);
            ObjectMapper mapper = new ObjectMapper();
            JSONObject jsonObject = (JSONObject) object;
            JSONArray json2 = (JSONArray) jsonObject.get("data");

            if (jsonObject.get("data") != null) {
                prepaidMobileRechargePlans = mapper.readValue(jsonObject.get("data").toString(), TypeFactory.defaultInstance()
                        .constructCollectionType(List.class, PrepaidMobileRechargePlans.class));
                /*Iterator iterator = json2.iterator();
                while(iterator.hasNext()){
                PrepaidMobileRechargePlans plan = new PrepaidMobileRechargePlans();
                JSONObject jsonChildObject = (JSONObject) iterator.next();
                
                plan.setId(jsonChildObject.get("id").toString());
                plan.setCircleid(jsonChildObject.get("circleid").toString());
                plan.setOperatorid(jsonChildObject.get("operatorid").toString());
                prepaidMobileRechargePlans.add(plan);
                
                
                }*/

            }

        }
        catch (ParseException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (org.json.simple.parser.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return prepaidMobileRechargePlans;
    }
}
