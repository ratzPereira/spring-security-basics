package com.ratz.springsecuritybasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBalanceController {

    @GetMapping("/myBalance")
    public String getMyBalance() {
        return "This is my Balance page";
    }
}
