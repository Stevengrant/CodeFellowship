package com.codefellowship.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;

@Entity
public class ApplicationUser implements UserDetails {

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getBio() {
        return bio;
    }

    private String lastName;
    private String dob;
    private String bio;

    public String getFirstName() {
        return firstName;
    }

    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;

    public ApplicationUser(String username, String password, String firstName, String lastName, String dob, String bio){
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.bio = bio;
    }
    public ApplicationUser(){};

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    public long getId() {
        return id;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
