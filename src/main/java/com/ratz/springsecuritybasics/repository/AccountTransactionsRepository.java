package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Integer> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
