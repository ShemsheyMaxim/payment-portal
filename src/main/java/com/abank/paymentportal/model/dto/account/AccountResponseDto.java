package com.abank.paymentportal.model.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountResponseDto {
    @JsonProperty("account_id")
    private Long id;
    @JsonProperty("account_num")
    private String accountNum;
    @JsonProperty("account_type")
    private String accountType;
    private double balance;
}
