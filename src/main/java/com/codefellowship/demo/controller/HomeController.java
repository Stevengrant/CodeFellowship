package com.codefellowship.demo.controller;

import com.codefellowship.demo.model.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String getIndex(Principal p, Model m) {

        if(p != null) {
            String u = p.getName();
            m.addAttribute("user", applicationUserRepository.findByUsername(u));
        }

        return "index";
    }
}
