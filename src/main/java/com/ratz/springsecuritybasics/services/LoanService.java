package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Loans;

import java.util.List;

public interface LoanService {

    List<Loans> findByCustomerIdOrder(int customerId);
}
