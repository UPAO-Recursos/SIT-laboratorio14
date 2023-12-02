package com.example.demojpalab.controllers;

import com.example.demojpalab.security.JwtTokenProvider;
import com.example.demojpalab.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("me")
    public String Me(HttpServletRequest req) {
        var token = jwtTokenProvider.resolveToken(req);
        var username = jwtTokenProvider.getUsername(token);
        var user = userRepository.findByUsername(username);
        if (user.isAdmin()) {
            // TODO: Aca acceso
        }
        return "Hola";
    }
}
