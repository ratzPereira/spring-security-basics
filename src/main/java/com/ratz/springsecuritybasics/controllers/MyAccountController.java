package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.Accounts;
import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.services.AccountsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAccountController {

    @Autowired
    private AccountsServiceImpl service;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = service.findCustomerById(customer.getId());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
