package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Contact;
import com.ratz.springsecuritybasics.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }
}
