package com.abank.paymentportal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountRequestDto {
    @JsonProperty("account_num")
    private int accountNum;
    @JsonProperty("account_type")
    private String accountType;
    private double balance;
}
