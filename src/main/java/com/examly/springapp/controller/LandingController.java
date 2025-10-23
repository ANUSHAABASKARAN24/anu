package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {
    @GetMapping("/")
    public String home() {
        return "Backend is running!";
    }
}
