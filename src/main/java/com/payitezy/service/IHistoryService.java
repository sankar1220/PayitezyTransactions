package com.payitezy.service;

import java.util.List;

import com.payitezy.domain.History;
import com.payitezy.domain.Users;

public interface IHistoryService {
	History create(History history);

    void deleteHistory(String historyId);

    History getHistory(String historyId);

    List<History> getAll();	  

    History updateHistory(History history);

}
