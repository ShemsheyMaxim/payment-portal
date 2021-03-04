package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.dto.AccountRequestDto;
import com.abank.paymentportal.model.dto.AccountResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.UserService;
import com.abank.paymentportal.service.mapper.AccountMapper;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final UserService userService;

    @PostMapping
    public void create(@RequestBody AccountRequestDto accountRequestDto) {
        Account account = accountMapper.toAccountEntity(accountRequestDto);
        accountService.create(account);
    }

    @GetMapping
    private Set<AccountResponseDto> getAllAccountsByUserId(@RequestParam("client_id") Long userId) {
        Set<Account> allAccountsById = userService.getAllAccountsById(userId);
        return allAccountsById.stream()
                .map(accountMapper::toAccountDto)
                .collect(Collectors.toSet());
    }
}
