
package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value="clickTransaction", collectionRelation="clickTransaction")
public class ClickTransactionResource extends ResourceWithEmbeddeds{
	private String clickTransactionId;
	private String usersId;
	private String merchantId;
	private String historyId;
	private String createdDate;
	private String status;
	private String urlClicked;
	private String clickedSource;
	private String orderStatus;
	private String clickedTarget;
	private String clickedTargetId;
	public String getClickTransactionId() {
		return clickTransactionId;
	}
	public void setClickTransactionId(String clickTransactionId) {
		this.clickTransactionId = clickTransactionId;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrlClicked() {
		return urlClicked;
	}
	public void setUrlClicked(String urlClicked) {
		this.urlClicked = urlClicked;
	}
	public String getClickedSource() {
		return clickedSource;
	}
	public void setClickedSource(String clickedSource) {
		this.clickedSource = clickedSource;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getClickedTarget() {
		return clickedTarget;
	}
	public void setClickedTarget(String clickedTarget) {
		this.clickedTarget = clickedTarget;
	}
	public String getClickedTargetId() {
		return clickedTargetId;
	}
	public void setClickedTargetId(String clickedTargetId) {
		this.clickedTargetId = clickedTargetId;
	}
	
}
