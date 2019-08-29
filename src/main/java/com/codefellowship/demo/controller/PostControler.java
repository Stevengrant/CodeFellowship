package com.codefellowship.demo.controller;

import com.codefellowship.demo.model.ApplicationUser;
import com.codefellowship.demo.model.ApplicationUserRepository;
import com.codefellowship.demo.model.Post;
import com.codefellowship.demo.model.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
public class PostControler {
    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @GetMapping("/posts")
    public String getUsersPosts( Model m, Principal p){
        String un = p.getName();
        ApplicationUser u = applicationUserRepository.findByUsername(un);
        System.out.println(u);
        if ( u != null){
            m.addAttribute("user",u);
            return "posts";
        }
        return "login";
    }
    @PostMapping("/posts")
    public RedirectView postUserPost(Principal p, String body){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        ApplicationUser u = applicationUserRepository.findByUsername(p.getName());
        Post post = new Post(body,ts, u);
        postRepository.save(post);
        return new RedirectView("/users/"+u.getId());
    }

}
