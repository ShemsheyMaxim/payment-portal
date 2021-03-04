package com.abank.paymentportal.service.mapper;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.dto.AccountRequestDto;
import com.abank.paymentportal.model.dto.AccountResponseDto;

public interface AccountMapper {
    AccountResponseDto toAccountDto(Account account);

    Account toAccountEntity(AccountRequestDto accountRequestDto);
}
