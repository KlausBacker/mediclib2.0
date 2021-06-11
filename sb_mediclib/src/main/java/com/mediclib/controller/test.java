package com.mediclib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class test {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to the fantastic mediclib!";
    }
}
