package com.abank.paymentportal.model.dto;

import com.abank.paymentportal.model.AccountType;
import lombok.Data;

@Data
public class AccountResponseDto {
    private Long id;
    private int accountNum;
    private AccountType accountType;
    private double balance;
}
