package com.practica1.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }


}
