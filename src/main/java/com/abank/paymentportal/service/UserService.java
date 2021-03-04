package com.abank.paymentportal.service;

import com.abank.paymentportal.model.User;
import java.util.List;

public interface UserService {
    User create(User user);

    List<User> getAll();
}
