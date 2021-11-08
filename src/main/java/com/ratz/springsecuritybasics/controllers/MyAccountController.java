package com.ratz.springsecuritybasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAccountController {

    @GetMapping("/myAccount")
    public String getMyAccount() {
        return "This is myAccount page";
    }
}
