package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.UserCreatedResponseDto;
import com.abank.paymentportal.model.dto.UserRequestDto;
import com.abank.paymentportal.service.UserService;
import com.abank.paymentportal.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserCreatedResponseDto> create(
            @RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.toUserEntity(userRequestDto);
        User createdUser = userService.create(user);
        UserCreatedResponseDto userCreatedResponseDto = new UserCreatedResponseDto();
        userCreatedResponseDto.setId(createdUser.getId());
        return new ResponseEntity<>(userCreatedResponseDto, HttpStatus.CREATED);
    }
}
