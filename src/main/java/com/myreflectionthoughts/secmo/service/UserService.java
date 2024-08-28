package com.myreflectionthoughts.secmo.service;

import com.myreflectionthoughts.secmo.dto.request.LoginRequest;
import com.myreflectionthoughts.secmo.dto.request.UserRegistrationRequest;
import com.myreflectionthoughts.secmo.dto.response.LoginResponse;
import com.myreflectionthoughts.secmo.dto.response.UserRegistrationResponse;
import com.myreflectionthoughts.secmo.entity.User;
import com.myreflectionthoughts.secmo.entity.UserPrincipal;
import com.myreflectionthoughts.secmo.repository.UserRepository;
import com.myreflectionthoughts.secmo.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager) throws NoSuchAlgorithmException {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = new JwtUtils();
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public UserRegistrationResponse addUser(UserRegistrationRequest request) {

        User user = new User();

        user.setUserName(request.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setAge(request.getAge());

        return map(userRepository.save(user));
    }

    public LoginResponse verifyLogin(LoginRequest request){
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        LoginResponse response = new LoginResponse();

        if(authentication.isAuthenticated()){
            UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
            response.setToken(jwtUtils.generateJwtToken(userPrincipal.getUsername()));
            response.setUserName(userPrincipal.getUsername());
            response.setUserId(userPrincipal.getUserId());
            return response;
        }else{
            System.out.println("User is not authenticated");
        }

        return response;
    }

    private UserRegistrationResponse map(User user){
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setAge(user.getAge());
        return response;
    }
}
