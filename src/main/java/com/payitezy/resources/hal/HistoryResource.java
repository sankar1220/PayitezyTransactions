package com.payitezy.resources.hal;

import org.springframework.hateoas.core.Relation;

@Relation(value = "history", collectionRelation = "history")
public class HistoryResource extends ResourceWithEmbeddeds{
	private String historyId;
	private String usersId;
	private String url;
	private String createdDate;
	private String historyType;
	private String channel;
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getHistoryType() {
		return historyType;
	}
	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
