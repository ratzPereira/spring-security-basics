package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.Entity.Loans;
import com.ratz.springsecuritybasics.services.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyLoansController {


    @Autowired
    private LoanServiceImpl service;

    @PostMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = service.findByCustomerIdOrder(customer.getId());
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
