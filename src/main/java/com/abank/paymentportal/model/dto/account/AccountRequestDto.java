package com.abank.paymentportal.model.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountRequestDto {
    @JsonProperty("account_num")
    @NotNull(message = "Account number can't be null")
    @NotEmpty(message = "Account number can't be empty")
    private String accountNum;
    @JsonProperty("account_type")
    @NotNull(message = "Account type can't be null")
    @NotEmpty(message = "Account type can't be empty")
    private String accountType;
    @Min(value = 0, message = "balance can't be negative")
    private double balance;
}
