package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.AccountTransactions;

import java.util.List;

public interface AccountTransactionsService {

    List<AccountTransactions> getTransactionsById(int id);
}
