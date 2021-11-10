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
        List<Customer> customer = repository.findByEmail(s);
        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user : " + s);
        }
        return new SecurityCustomer(customer.get(0));
    }
}
