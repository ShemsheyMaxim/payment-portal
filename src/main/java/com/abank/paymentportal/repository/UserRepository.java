package com.abank.paymentportal.repository;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.User;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.accounts FROM User u WHERE u.id = :id")
    Set<Account> getAllAccountsById(Long id);
}
