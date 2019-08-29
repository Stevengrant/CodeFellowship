package com.codefellowship.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String body;

    @ManyToOne
    ApplicationUser poster;

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    Timestamp createdAt;
    public Post(String body, Timestamp createdAt, ApplicationUser poster){
        this.body = body;
        this.createdAt = createdAt;
        this.poster = poster;
    }
    public Post(){};
}
