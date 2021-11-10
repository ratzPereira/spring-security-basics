package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Accounts;
import com.ratz.springsecuritybasics.Entity.Customer;

public interface AccountsService {

    Accounts findCustomerById(int id);
}
