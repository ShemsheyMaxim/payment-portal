package com.abank.paymentportal.service.impl;

import com.abank.paymentportal.model.Account;
import com.abank.paymentportal.model.User;
import com.abank.paymentportal.repository.UserRepository;
import com.abank.paymentportal.service.UserService;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
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
    public Set<Account> getAllAccountsById(Long userId) {
        return userRepository.getAllAccountsById(userId);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("User by id " + userId + " not found in table"));
    }
}
