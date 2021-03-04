package com.abank.paymentportal.service;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.User;
import java.util.Set;

public interface UserService {
    User create(User user);

    Set<Account> getAllAccountsById(Long userId);

    User getById(Long userId);
}
