package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Loans;
import com.ratz.springsecuritybasics.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    @Override
    @PreAuthorize("hasRole('ROOT')")
    public List<Loans> findByCustomerIdOrder(int customerId) {
        return repository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}
