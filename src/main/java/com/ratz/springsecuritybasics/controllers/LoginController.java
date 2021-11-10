package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomRepository repository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Principal user) {
        List<Customer> customers = repository.findByEmail(user.getName());
        System.out.println(customers.get(0).getAuthorities().toString());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }
    }
}
