package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

    Accounts findByCustomerId(int customerId);
}
