package com.payitezy.domain;

// Generated 7 May, 2016 4:24:03 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Merchant generated by hbm2java
 */
@Entity
@Table(name = "merchant", catalog = "payitezy")
public class Merchant extends AbstractDomain implements java.io.Serializable {

	private String affliateId;
	private String merchantToken;
	private String merchantName;
	private String merchantImage;
	private Set<ClickTransaction> clickTransactions = new HashSet<ClickTransaction>(
			0);

	public Merchant() {
	}

	public Merchant( String affliateId, String merchantToken,
			String merchantName, String merchantImage) {
		this.affliateId = affliateId;
		this.merchantToken = merchantToken;
		this.merchantName = merchantName;
		this.merchantImage = merchantImage;
	}

	public Merchant( String affliateId, String merchantToken,
			String merchantName, String merchantImage,
			Set<ClickTransaction> clickTransactions) {
		this.affliateId = affliateId;
		this.merchantToken = merchantToken;
		this.merchantName = merchantName;
		this.merchantImage = merchantImage;
		this.clickTransactions = clickTransactions;
	}

	

	@Column(name = "affliate_id", nullable = false, length = 100)
	public String getAffliateId() {
		return this.affliateId;
	}

	public void setAffliateId(String affliateId) {
		this.affliateId = affliateId;
	}

	@Column(name = "merchant_token", nullable = false, length = 100)
	public String getMerchantToken() {
		return this.merchantToken;
	}

	public void setMerchantToken(String merchantToken) {
		this.merchantToken = merchantToken;
	}

	@Column(name = "merchant_name", nullable = false, length = 45)
	public String getMerchantName() {
		return this.merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	@Column(name = "merchant_image", nullable = false, length = 100)
	public String getMerchantImage() {
		return this.merchantImage;
	}

	public void setMerchantImage(String merchantImage) {
		this.merchantImage = merchantImage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<ClickTransaction> getClickTransactions() {
		return this.clickTransactions;
	}

	public void setClickTransactions(Set<ClickTransaction> clickTransactions) {
		this.clickTransactions = clickTransactions;
	}

}
