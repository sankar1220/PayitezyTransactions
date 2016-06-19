package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value="apiKeys" , collectionRelation="apiKeys")
public class ApiKeysResource extends ResourceWithEmbeddeds{
	private String apiKeysId;
	private String apiDetails;
	private String keyName;
	private String keyValue;
	private String status;
	private String createdDate;
	public String getApiKeysId() {
		return apiKeysId;
	}
	public void setApiKeysId(String apiKeysId) {
		this.apiKeysId = apiKeysId;
	}
	public String getApiDetails() {
		return apiDetails;
	}
	public void setApiDetails(String apiDetails) {
		this.apiDetails = apiDetails;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
