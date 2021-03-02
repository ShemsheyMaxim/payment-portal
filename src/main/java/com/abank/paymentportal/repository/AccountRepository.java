package com.abank.paymentportal.repository;

import com.abank.paymentportal.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
