package com.abank.paymentportal.service.mapper;

import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.UserRequestDto;
import com.abank.paymentportal.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto toUserDto(User user);

    User toUserEntity(UserRequestDto userRequestDto);
}
