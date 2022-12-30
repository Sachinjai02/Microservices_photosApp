package com.study.usersservice.services;

import com.study.usersservice.models.User;
import com.study.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User createService(User userReq) {
        userReq.setUserId(UUID.randomUUID().toString());
        userReq.setEncryptedPwd(passwordEncoder.encode(userReq.getPassword()));
        return userRepository.save(userReq);

    }
}
