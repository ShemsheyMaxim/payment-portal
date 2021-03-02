package com.abank.paymentportal.model.dto;

import com.abank.paymentportal.model.AccountType;
import lombok.Data;

@Data
public class AccountRequestDto {
    private int accountNum;
    private AccountType accountType;
    private double balance;
}
