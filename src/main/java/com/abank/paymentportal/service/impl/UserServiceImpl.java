package com.abank.paymentportal.service.impl;

import com.abank.paymentportal.model.User;
import com.abank.paymentportal.repository.UserRepository;
import com.abank.paymentportal.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
