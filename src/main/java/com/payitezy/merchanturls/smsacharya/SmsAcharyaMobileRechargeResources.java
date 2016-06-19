package com.payitezy.merchanturls.smsacharya;

import com.payitezy.APIKeys;
import com.payitezy.QueryService;
import com.payitezy.apiobjects.MobileOperator;
import com.payitezy.apiobjects.PostpaidMobilePayment;
import com.payitezy.apiobjects.PrepaidMobileRecharge;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsAcharyaMobileRechargeResources {
    @Autowired
    private QueryService queryService;
    private String uid = APIKeys.SMSACHARYAUID.getSequenceName();
    private String pin = APIKeys.SMSACHARYAPIN.getSequenceName();
    private String apiVersion = APIKeys.SMSACHARYAAPIVERSION.getSequenceName();

    public MobileOperator getMobileOperatorCircleByMobileNumber(final String mobileNumber) {
        MobileOperator mobileOperator = new MobileOperator();

        String apiUrl = "http://smsalertbox.com/api/getnetwork.php?uid=" + uid + "&pin=" + pin + "&mobile=" + mobileNumber
                + "&format=json&version=" + apiVersion;

        try {
            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(apiUrl).getEntity());
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonString);
            JSONObject json = (JSONObject) obj;
            mobileOperator.setCircle(json.get("circle").toString());
            mobileOperator.setOperator(json.get("operator").toString());
            mobileOperator.setError((String) json.get("error"));
            mobileOperator.setMessage((String) json.get("message"));

        }
        catch (ParseException e) {
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

        return mobileOperator;
    }

    public PostpaidMobilePayment getPostpaidMobilePaymentByMobileNumber(final PostpaidMobilePayment postpaidMobilePayment) {

        PostpaidMobilePayment postpaidMobileBillPayment = new PostpaidMobilePayment();

        String postpaidUrl = "http://smsalertbox.com/api/recharge.php?uid=" + uid + "&pin=" + pin + "&number="
                + postpaidMobilePayment.getNumber() + "&operator=" + postpaidMobilePayment.getOperator() + "&circle="
                + postpaidMobilePayment.getCircle() + "&amount=" + postpaidMobilePayment.getAmount() + "&format=json&version=" + apiVersion;

        try {
            String postpaidJsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(postpaidUrl).getEntity());
            JSONParser jsonParser = new JSONParser();
            Object postpaidObject = jsonParser.parse(postpaidJsonString);
            JSONObject postpaidJson = (JSONObject) postpaidObject;

            if (postpaidJson.get("amount") != null) {
                postpaidMobileBillPayment.setAmount(postpaidJson.get("amount").toString());
            }
            if (postpaidJson.get("balance") != null) {
                postpaidMobileBillPayment.setBalance(postpaidJson.get("balance").toString());
            }
            if (postpaidJson.get("error_code") != null) {
                postpaidMobileBillPayment.setError_code(postpaidJson.get("error_code").toString());
            }
            if (postpaidJson.get("message") != null) {
                postpaidMobileBillPayment.setMessage(postpaidJson.get("message").toString());
            }
            if (postpaidJson.get("number") != null) {
                postpaidMobileBillPayment.setNumber(postpaidJson.get("number").toString());
            }
            if (postpaidJson.get("operator") != null) {
                postpaidMobileBillPayment.setOperator(postpaidJson.get("operator").toString());
            }
            if (postpaidJson.get("operatorReference") != null) {
                postpaidMobileBillPayment.setOperatorReference(postpaidJson.get("operatorReference").toString());
            }
            if (postpaidJson.get("status") != null) {
                postpaidMobileBillPayment.setStatus(postpaidJson.get("status").toString());
            }
            if (postpaidJson.get("time") != null) {
                postpaidMobileBillPayment.setTime(postpaidJson.get("time").toString());
            }
            if (postpaidJson.get("transactionId") != null) {
                postpaidMobileBillPayment.setTransactionId(postpaidJson.get("transactionId").toString());
            }
            /*postpaidMobileBillPayment.setUserTxid((String) postpaidJson.get("userTxid")
            		.toString());*/
            if (postpaidJson.get("yourCost") != null) {
                postpaidMobileBillPayment.setYourCost(postpaidJson.get("yourCost").toString());
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

        return postpaidMobileBillPayment;
    }

    public PrepaidMobileRecharge getPrepaidMobileRechargeByMobileNumber(final PrepaidMobileRecharge prepaidMobileRecharge) {

        PrepaidMobileRecharge prepaidMobileRechargeResult = new PrepaidMobileRecharge();

        String apiUrl = "http://smsalertbox.com/api/recharge.php?uid=" + uid + "&pin=" + pin + "&number="
                + prepaidMobileRecharge.getNumber() + "&operator=" + prepaidMobileRecharge.getOperator() + "&circle="
                + prepaidMobileRecharge.getCircle() + "&amount=" + prepaidMobileRecharge.getAmount() + "&format=json&version=" + apiVersion;

        try {
            String jsonString = EntityUtils.toString(queryService.sendHttpRequestAndResponse(apiUrl).getEntity());
            JSONParser jsonParser = new JSONParser();
            Object obj1 = jsonParser.parse(jsonString);
            JSONObject json = (JSONObject) obj1;
            if (json.get("amount") != null) {
                prepaidMobileRechargeResult.setAmount(json.get("amount").toString());
            }
            if (json.get("balance") != null) {
                prepaidMobileRechargeResult.setBalance(json.get("balance").toString());
            }
            if (json.get("error_code") != null) {
                prepaidMobileRechargeResult.setError_code(json.get("error_code").toString());
            }
            if (json.get("message") != null) {
                prepaidMobileRechargeResult.setMessage(json.get("message").toString());
            }
            if (json.get("number") != null) {
                prepaidMobileRechargeResult.setNumber(json.get("number").toString());
            }
            if (json.get("operator") != null) {
                prepaidMobileRechargeResult.setOperator(json.get("operator").toString());
            }
            if (json.get("operatorReference") != null) {
                prepaidMobileRechargeResult.setOperatorReference(json.get("operatorReference").toString());
            }
            if (json.get("status") != null) {
                prepaidMobileRechargeResult.setStatus(json.get("status").toString());
            }
            if (json.get("time") != null) {
                prepaidMobileRechargeResult.setTime(json.get("time").toString());
            }
            if (json.get("transactionId") != null) {
                prepaidMobileRechargeResult.setTransactionId(json.get("transactionId").toString());
            }
            /*prepaidMobileRechargeResult.setUserTxid((String) json.get("userTxid")
            		.toString());*/
            if (json.get("yourCost") != null) {
                prepaidMobileRechargeResult.setYourCost(json.get("yourCost").toString());
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

        return prepaidMobileRechargeResult;

    }

}
