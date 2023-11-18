package com.example.demojpalab.controllers;

import com.example.demojpalab.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public String login() {
        var a = userRepository.findAll();
        return "Hola";
    }


    @PostMapping("get")
    public String get() {
        var a = userRepository.findAll();
        return "Hola";
    }
}
