package com.payitezy.merchanturls.smsacharya;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.LandlineBillPayment;

@Component
public class LandlineBillPaymentUrlResources {
	@Autowired
	private QueryService queryService;
	private String uid = APIKeys.SMSACHARYAUID.getSequenceName();
	private String pin = APIKeys.SMSACHARYAPIN.getSequenceName();
	private String apiVersion = APIKeys.SMSACHARYAAPIVERSION.getSequenceName();
	
	public LandlineBillPayment getLandLineBillPaymentByNumber(final LandlineBillPayment lindlineBillPayment){
		
		LandlineBillPayment landlineBillPaymentObj = new LandlineBillPayment();
		
		String postpaidUrl="http://smsalertbox.com/api/recharge.php?uid=" + uid
				+ "&pin=" + pin + "&number=" + landlineBillPaymentObj.getNumber() + "&operator="
				+ landlineBillPaymentObj.getOperator() + "&circle=" + landlineBillPaymentObj.getCircle() + "&amount=" + landlineBillPaymentObj.getAmount()
				+ "&format=json&version=" + apiVersion;
		
		try {
			String landlineJsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(postpaidUrl).getEntity());
			JSONParser parser = new JSONParser();
			Object parsedObject= parser.parse(landlineJsonString);
			JSONObject landlineObj = (JSONObject)parsedObject;
			
			if(landlineObj.get("amount")!=null){
				landlineBillPaymentObj.setAmount((String) landlineObj.get("amount")
						.toString());
				}
				if(landlineObj.get("balance")!=null){
				landlineBillPaymentObj.setBalance((String) landlineObj.get("balance")
						.toString());
				}
				if(landlineObj.get("error_code")!=null){
				landlineBillPaymentObj.setError_code((String) landlineObj.get("error_code")
						.toString());
				}
				if(landlineObj.get("message")!=null){
				landlineBillPaymentObj.setMessage((String) landlineObj.get("message")
						.toString());
				}
				if(landlineObj.get("number")!=null){
				landlineBillPaymentObj.setNumber((String) landlineObj.get("number")
						.toString());
				}
				if(landlineObj.get("operator")!=null){
				landlineBillPaymentObj.setOperator((String) landlineObj.get("operator")
						.toString());
				}
				if(landlineObj.get("operatorReference")!=null){
				landlineBillPaymentObj.setOperatorReference((String) landlineObj.get(
						"operatorReference").toString());
				}
				if(landlineObj.get("status")!=null){
				landlineBillPaymentObj.setStatus((String) landlineObj.get("status")
						.toString());
				}
				if(landlineObj.get("time")!=null){
				landlineBillPaymentObj.setTime((String) landlineObj.get("time").toString());
				}
				if(landlineObj.get("transactionId")!=null){
				landlineBillPaymentObj.setTransactionId((String) landlineObj.get(
						"transactionId").toString());
				}
				/*landlineBillPaymentObj.setUserTxid((String) landlineObj.get("userTxid")
						.toString());*/
				if(landlineObj.get("yourCost")!=null){
				landlineBillPaymentObj.setYourCost((String) landlineObj.get("yourCost")
						.toString());
				}
		
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return landlineBillPaymentObj;
	}
}
