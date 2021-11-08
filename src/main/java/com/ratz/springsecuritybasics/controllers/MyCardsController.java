package com.ratz.springsecuritybasics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCardsController {


    @GetMapping("/myCards")
    public String getMyCards() {
        return "This is my Cards page";
    }

}
