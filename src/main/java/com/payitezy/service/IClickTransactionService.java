package com.payitezy.service;

import java.util.List;

import com.payitezy.domain.ClickTransaction;
import com.payitezy.domain.Users;

public interface IClickTransactionService {
	ClickTransaction create(ClickTransaction clickTransaction);

    void deleteClickTransaction(String clickTransactionId);

    ClickTransaction getClickTransaction(String clickTransactionId);

    List<ClickTransaction> getAll();	  

    ClickTransaction updateClickTransaction(ClickTransaction clickTransaction);
}
