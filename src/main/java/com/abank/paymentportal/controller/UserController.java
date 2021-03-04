package com.abank.paymentportal.controller;

import com.abank.paymentportal.model.User;
import com.abank.paymentportal.model.dto.UserCreatedResponseDto;
import com.abank.paymentportal.model.dto.UserRequestDto;
import com.abank.paymentportal.model.dto.UserResponseDto;
import com.abank.paymentportal.service.AccountService;
import com.abank.paymentportal.service.UserService;
import com.abank.paymentportal.service.mapper.AccountMapper;
import com.abank.paymentportal.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<UserCreatedResponseDto> create(
            @RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.toUserEntity(userRequestDto);
        User createdUser = userService.create(user);
        UserCreatedResponseDto userCreatedResponseDto = new UserCreatedResponseDto();
        userCreatedResponseDto.setId(createdUser.getId());
        return new ResponseEntity<>(userCreatedResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> all = userService.getAll();
        return all.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
