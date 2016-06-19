package com.payitezy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.payitezy.domain.ClickTransaction;
import com.payitezy.domain.Users;

@Component("historyModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HistoryModel extends AbstractModel {
	private String usersId;
	private String url;
	private String createdDate;
	private String historyType;
	private String channel;
	private List<ClickTransactionModel> clickTransactionModels = new ArrayList<ClickTransactionModel>(
			0);
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
	public List<ClickTransactionModel> getClickTransactionModels() {
		return clickTransactionModels;
	}
	public void setClickTransactionModels(
			List<ClickTransactionModel> clickTransactionModels) {
		this.clickTransactionModels = clickTransactionModels;
	}
	
}
