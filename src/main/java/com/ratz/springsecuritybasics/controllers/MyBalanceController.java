package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.AccountTransactions;
import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.services.AccountTransactionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyBalanceController {

    @Autowired
    private AccountTransactionsServiceImpl service;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransactions> accountTransactions = service.getTransactionsById(customer.getId());
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}
