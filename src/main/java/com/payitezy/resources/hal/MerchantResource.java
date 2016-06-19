package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value="merchant", collectionRelation="merchant")
public class MerchantResource extends ResourceWithEmbeddeds{
	private String merchantId;
	private String affliateId;
	private String merchantToken;
	private String merchantName;
	private String merchantImage;
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
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
	

}
