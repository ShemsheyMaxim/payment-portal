package com.abank.paymentportal.service.impl;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.repository.AccountRepository;
import com.abank.paymentportal.service.AccountService;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void createAll(Set<Account> accounts) {
        accountRepository.saveAll(accounts);
    }

    @Override
    public Account getById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() ->
                new EntityNotFoundException("Account by id " + accountId + " not found in table"));
    }
}
