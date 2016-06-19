package com.payitezy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.payitezy.domain.ClickTransaction;

@Component("merchantModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MerchantModel extends AbstractModel {
	private String affliateId;
	private String merchantToken;
	private String merchantName;
	private String merchantImage;
	private List<ClickTransactionModel> clickTransactionModels = new ArrayList<ClickTransactionModel>(
			0);
	public String getAffliateId() {
		return affliateId;
	}
	public void setAffliateId(String affliateId) {
		this.affliateId = affliateId;
	}
	public String getMerchantToken() {
		return merchantToken;
	}
	public void setMerchantToken(String merchantToken) {
		this.merchantToken = merchantToken;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantImage() {
		return merchantImage;
	}
	public void setMerchantImage(String merchantImage) {
		this.merchantImage = merchantImage;
	}
	public List<ClickTransactionModel> getClickTransactionModels() {
		return clickTransactionModels;
	}
	public void setClickTransactionModels(
			List<ClickTransactionModel> clickTransactionModels) {
		this.clickTransactionModels = clickTransactionModels;
	}
	

}
