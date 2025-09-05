package com.anfega.model.user.gateways;

import com.anfega.model.user.User;

public interface UserInputPort {
    User getUserById(Long id);
    User saveUser(User user);
}
