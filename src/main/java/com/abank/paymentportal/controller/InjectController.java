package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.AccountType;
import com.abank.paymentportal.service.AccountTypeService;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectController {
    private final AccountTypeService accountTypeService;

    @PostConstruct
    private void injectAccount() {
        AccountType accountType = new AccountType();
        accountType.setNameType(AccountType.NameType.CARD_SIMPLE);
        accountTypeService.create(accountType);
    }
}
