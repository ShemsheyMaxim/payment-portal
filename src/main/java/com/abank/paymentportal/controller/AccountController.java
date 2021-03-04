package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.dto.account.AccountRequestDto;
import com.abank.paymentportal.model.dto.account.AccountResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.UserService;
import com.abank.paymentportal.service.mapper.AccountMapper;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AccountResponseDto> create(
            @Valid @RequestBody AccountRequestDto accountRequestDto) {
        Account account = accountMapper.toAccountEntity(accountRequestDto);
        Account createdAccount = accountService.create(account);
        AccountResponseDto accountResponseDto = accountMapper.toAccountDto(createdAccount);
        return new ResponseEntity<>(accountResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    private Set<AccountResponseDto> getAllAccountsByUserId(@RequestParam("client_id") Long userId) {
        Set<Account> allAccountsById = userService.getAllAccountsById(userId);
        return allAccountsById.stream()
                .map(accountMapper::toAccountDto)
                .collect(Collectors.toSet());
    }
}
