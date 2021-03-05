package com.abank.paymentportal.model.dto.user;

import com.abank.paymentportal.model.Account;
import java.util.Set;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Account> accounts;
}
