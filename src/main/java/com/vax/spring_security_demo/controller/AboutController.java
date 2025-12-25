package com.vax.spring_security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("about")
public class AboutController {

    @GetMapping
    public String info() {
        return "Welcome to Spring Security Demo";
    }
}
