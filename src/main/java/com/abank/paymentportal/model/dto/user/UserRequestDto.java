package com.abank.paymentportal.model.dto.user;

import com.abank.paymentportal.model.dto.account.AccountRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {
    @JsonProperty("first_name")
    @NotNull(message = "First name can't be null")
    @NotEmpty(message = "First name can't be empty")
    private String firstName;
    @JsonProperty("last_name")
    @NotNull(message = "Last name can't be null")
    @NotEmpty(message = "Last name can't be empty")
    private String lastName;
    private Set<AccountRequestDto> accounts;
}
