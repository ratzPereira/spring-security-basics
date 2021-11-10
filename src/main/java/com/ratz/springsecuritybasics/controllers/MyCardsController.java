package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.Cards;
import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.services.CardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyCardsController {

    @Autowired
    private CardsServiceImpl cardsService;


    @GetMapping("/myCards")
    public List<Cards> getMyCards(@RequestBody Customer customer) {

        List<Cards> cards = cardsService.getCardsByCustomerId(customer.getId());
        return cards.isEmpty() ? cards : null;
    }

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsService.getCardsByCustomerId(customer.getId());
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

}
