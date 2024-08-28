package com.myreflectionthoughts.secmo.service;

import com.myreflectionthoughts.secmo.dto.request.UserRegistrationRequest;
import com.myreflectionthoughts.secmo.dto.response.UserRegistrationResponse;
import com.myreflectionthoughts.secmo.entity.User;
import com.myreflectionthoughts.secmo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public UserRegistrationResponse addUser(UserRegistrationRequest request) {

        User user = new User();

        user.setUserName(request.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setAge(request.getAge());

        return map(userRepository.save(user));
    }

    private UserRegistrationResponse map(User user){
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setAge(user.getAge());
        return response;
    }
}
