package com.abank.paymentportal.model.dto;

import lombok.Data;

@Data
public class AccountResponseDto {
    private Long id;
    private int accountNum;
    private String accountType;
    private double balance;
}
