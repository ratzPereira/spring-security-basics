package com.ratz.springsecuritybasics.config;

import com.ratz.springsecuritybasics.Entity.Customer;
import com.ratz.springsecuritybasics.model.SecurityCustomer;
import com.ratz.springsecuritybasics.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatzBankUserDetails implements UserDetailsService {

    @Autowired
    private CustomRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Customer> customers = repository.findByEmail(s);
        if (customers.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }
        return new SecurityCustomer(customers.get(0));
    }
}
