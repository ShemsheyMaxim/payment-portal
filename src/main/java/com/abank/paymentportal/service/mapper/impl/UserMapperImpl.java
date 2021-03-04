package com.abank.paymentportal.service.mapper.impl;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.AccountRequestDto;
import com.abank.paymentportal.model.dto.UserRequestDto;
import com.abank.paymentportal.model.dto.UserResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.mapper.AccountMapper;
import com.abank.paymentportal.service.mapper.UserMapper;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class UserMapperImpl implements UserMapper {
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Override
    public UserResponseDto toUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setAccounts(user.getAccounts());
        return userResponseDto;
    }

    @Override
    public User toUserEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        Set<AccountRequestDto> accountsFromRequestDto = userRequestDto.getAccounts();
        Set<Account> accounts = accountsFromRequestDto.stream()
                .map(accountMapper::toAccountEntity)
                .collect(Collectors.toSet());
        accountService.createAll(accounts);
        user.setAccounts(accounts);
        return user;
    }
}
