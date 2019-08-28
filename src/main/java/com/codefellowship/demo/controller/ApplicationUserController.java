package com.codefellowship.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationUserController {
    //todo login get
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    //todo login post
    //todo sign up get
    @GetMapping
    public String getSignup(){
        return "signup";
    }
    //todo sign up post

}
