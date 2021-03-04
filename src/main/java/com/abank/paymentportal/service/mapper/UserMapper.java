package com.abank.paymentportal.service.mapper;

import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.user.UserRequestDto;
import com.abank.paymentportal.model.dto.user.UserResponseDto;

public interface UserMapper {
    UserResponseDto toUserDto(User user);

    User toUserEntity(UserRequestDto userRequestDto);
}
