

package com.payitezy.merchanturls.smsacharya;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.DTHBillPayment;

@Component
public class DTHBillPaymentUrlResource {
	@Autowired
	private QueryService queryService;
	private String uid = APIKeys.SMSACHARYAUID.getSequenceName();
	private String pin = APIKeys.SMSACHARYAPIN.getSequenceName();
	private String apiVersion = APIKeys.SMSACHARYAAPIVERSION.getSequenceName();
	
	public DTHBillPayment getDTHBillPaymentByNumber(final DTHBillPayment dthBillPayment){
		
		DTHBillPayment dthBillPaymentObj = new DTHBillPayment();
		
		String postpaidUrl="http://smsalertbox.com/api/recharge.php?uid=" + uid
				+ "&pin=" + pin + "&number=" + dthBillPaymentObj.getNumber() + "&operator="
				+ dthBillPaymentObj.getOperator() + "&circle=" + dthBillPaymentObj.getCircle() + "&amount=" + dthBillPaymentObj.getAmount()
				+ "&format=json&version=" + apiVersion;
		
		try {
			String dthJsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(postpaidUrl).getEntity());
			JSONParser parser = new JSONParser();
			Object parsedObject= parser.parse(dthJsonString);
			JSONObject dthObj = (JSONObject)parsedObject;
			
			if(dthObj.get("amount")!=null){
				dthBillPaymentObj.setAmount((String) dthObj.get("amount")
						.toString());
				}
				if(dthObj.get("balance")!=null){
					dthBillPaymentObj.setBalance((String) dthObj.get("balance")
						.toString());
				}
				if(dthObj.get("error_code")!=null){
					dthBillPaymentObj.setError_code((String) dthObj.get("error_code")
						.toString());
				}
				if(dthObj.get("message")!=null){
					dthBillPaymentObj.setMessage((String) dthObj.get("message")
						.toString());
				}
				if(dthObj.get("number")!=null){
					dthBillPaymentObj.setNumber((String) dthObj.get("number")
						.toString());
				}
				if(dthObj.get("operator")!=null){
					dthBillPaymentObj.setOperator((String) dthObj.get("operator")
						.toString());
				}
				if(dthObj.get("operatorReference")!=null){
					dthBillPaymentObj.setOperatorReference((String) dthObj.get(
						"operatorReference").toString());
				}
				if(dthObj.get("status")!=null){
					dthBillPaymentObj.setStatus((String) dthObj.get("status")
						.toString());
				}
				if(dthObj.get("time")!=null){
					dthBillPaymentObj.setTime((String) dthObj.get("time").toString());
				}
				if(dthObj.get("transactionId")!=null){
					dthBillPaymentObj.setTransactionId((String) dthObj.get(
						"transactionId").toString());
				}
				if(dthObj.get("userTxid") != null){
				dthBillPaymentObj.setUserTxid((String) dthObj.get("userTxid")
						.toString());
				}
				if(dthObj.get("yourCost")!=null){
					dthBillPaymentObj.setYourCost((String) dthObj.get("yourCost")
						.toString());
				}
		
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dthBillPaymentObj;
	}
}
