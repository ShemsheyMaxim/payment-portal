package com.abank.paymentportal.service.impl;

import com.abank.paymentportal.model.AccountType;
import com.abank.paymentportal.repository.AccountTypeRepository;
import com.abank.paymentportal.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {
    private final AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType create(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType getAccountTypeByNameType(AccountType.NameType nameType) {
        return accountTypeRepository.getAccountTypeByNameType(nameType);
    }
}
