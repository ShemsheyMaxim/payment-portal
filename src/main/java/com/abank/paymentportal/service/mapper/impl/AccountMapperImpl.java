package com.abank.paymentportal.service.mapper.impl;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.AccountType;
import com.abank.paymentportal.model.dto.account.AccountRequestDto;
import com.abank.paymentportal.model.dto.account.AccountResponseDto;
import com.abank.paymentportal.service.AccountTypeService;
import com.abank.paymentportal.service.mapper.AccountMapper;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapperImpl implements AccountMapper {
    private final AccountTypeService accountTypeService;

    @Override
    public AccountResponseDto toAccountDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setId(account.getId());
        accountResponseDto.setAccountNum(account.getAccountNum());
        String accountType = account.getAccountType().getNameType().getType();
        accountResponseDto.setAccountType(accountType);
        accountResponseDto.setBalance(account.getBalance());
        return accountResponseDto;
    }

    @Override
    public Account toAccountEntity(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountNum(accountRequestDto.getAccountNum());
        AccountType.NameType nameType = Arrays.stream(AccountType.NameType.values())
                .filter(n -> n.getType().equals(accountRequestDto.getAccountType()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't find account type in table from able type"));
        AccountType accountTypeByNameType = accountTypeService
                .getAccountTypeByNameType(nameType);
        account.setAccountType(accountTypeByNameType);
        account.setBalance(accountRequestDto.getBalance());
        return account;
    }
}
