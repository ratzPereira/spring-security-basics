package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Accounts;
import com.ratz.springsecuritybasics.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService{


    @Autowired
    private AccountsRepository repository;

    @Override
    public Accounts findCustomerById(int id) {
        return repository.findByCustomerId(id);
    }
}
