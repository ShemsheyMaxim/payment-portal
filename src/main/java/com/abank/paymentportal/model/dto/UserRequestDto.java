package com.abank.paymentportal.model.dto;

import com.abank.paymentportal.model.Account;
import java.util.Set;
import lombok.Data;

@Data
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private Set<Account> accounts;
}
