package com.myreflectionthoughts.secmo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String greetUser(){
        return "!! Welcome, user !!";
    }

}
