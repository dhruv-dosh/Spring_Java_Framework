package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.MemberPo;
import com.example.Service.MyUserDetailsService;
@RestController
public class UserController {

    @Autowired
    MyUserDetailsService service;

    @GetMapping("/guest")
    public String guest() {
        return "Hello, Guest!";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "Hello, User!";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "Hello, Admin!";
    }

    @GetMapping("/getEmail")
    public String getEmail() {
        return "Your email is:";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody MemberPo registrationDto) {
        return service.registerUser(registrationDto);
    }
}
