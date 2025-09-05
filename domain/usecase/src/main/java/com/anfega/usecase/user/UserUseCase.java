package com.anfega.usecase.user;

import com.anfega.model.user.User;
import com.anfega.model.user.gateways.UserInputPort;
import com.anfega.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase implements UserInputPort {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
