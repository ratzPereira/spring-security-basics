package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Cards, Integer> {

    List<Cards> findByCustomerId(int customerId);
}
