package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Cards;
import com.ratz.springsecuritybasics.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardRepository repository;

    public List<Cards> getCardsByCustomerId(int id) {
        return repository.findByCustomerId(id);
    }
}
