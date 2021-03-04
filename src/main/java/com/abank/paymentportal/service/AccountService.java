package com.abank.paymentportal.service;

import com.abank.paymentportal.model.Account;
import java.util.Set;

public interface AccountService {
    Account create(Account account);

    void createAll(Set<Account> accounts);
}
