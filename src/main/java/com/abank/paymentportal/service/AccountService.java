package com.abank.paymentportal.service;

import com.abank.paymentportal.model.Account;
import java.util.List;
import java.util.Set;

public interface AccountService {
    Account create(Account account);

    List<Account> getAll();

    void createAll(Set<Account> accounts);
}
