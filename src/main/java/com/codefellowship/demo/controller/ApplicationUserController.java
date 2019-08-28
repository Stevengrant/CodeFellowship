package com.codefellowship.demo.controller;

import com.codefellowship.demo.model.ApplicationUser;
import com.codefellowship.demo.model.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PasswordEncoder encoder;
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    //todo login post
    @GetMapping
    public String getSignup(){
        return "signup";
    }
    //todo sign up post
    @PostMapping("/signup")
    public RedirectView postSignup(String username, String password, String firstName, String lastName, String dob, String bio){
        ApplicationUser u = new ApplicationUser(username, encoder.encode(password), firstName, lastName, dob, bio);
        applicationUserRepository.save(u);
        return new RedirectView("/");
    }
}
