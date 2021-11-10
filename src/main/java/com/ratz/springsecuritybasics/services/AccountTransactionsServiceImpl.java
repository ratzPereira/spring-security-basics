package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.AccountTransactions;
import com.ratz.springsecuritybasics.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionsServiceImpl implements AccountTransactionsService{


    @Autowired
    private AccountTransactionsRepository repository;

    @Override
    public List<AccountTransactions> getTransactionsById(int id) {
        return repository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
