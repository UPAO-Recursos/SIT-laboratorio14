package com.example.demojpalab;

import com.example.demojpalab.security.JwtTokenProvider;
import com.example.demojpalab.user.User;
import com.example.demojpalab.user.UserRepository;
import com.example.demojpalab.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemojpalabApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemojpalabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setUsername("wleturia");
        admin.setPassword("wleturia");
        admin.setFullName("Walter Leturia");

        userRepository.save(admin);


        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        var token = jwtTokenProvider.createToken("wleturia", new ArrayList<>(Arrays.asList(UserRole.ROLE_ADMIN)));
        System.out.println(token);
    }
}
