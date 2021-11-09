package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Cards;

import java.util.List;


public interface CardsService {
    List<Cards> getCardsByCustomerId(int id);
}
