package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findByEmail(String email);
}
