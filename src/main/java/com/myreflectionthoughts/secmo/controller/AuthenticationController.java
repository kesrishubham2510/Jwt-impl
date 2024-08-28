package com.myreflectionthoughts.secmo.controller;

import com.myreflectionthoughts.secmo.dto.request.UserRegistrationRequest;
import com.myreflectionthoughts.secmo.dto.response.UserRegistrationResponse;
import com.myreflectionthoughts.secmo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest request){
        return ResponseEntity.ok(userService.addUser(request));
    }

}
