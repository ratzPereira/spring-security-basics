package com.ratz.springsecuritybasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyLoansController {

    @GetMapping("/myLoans")
    public String getMyLoans() {
        return "This is my Loans page";
    }
}
