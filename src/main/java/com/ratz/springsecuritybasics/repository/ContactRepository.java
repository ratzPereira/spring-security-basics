package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
