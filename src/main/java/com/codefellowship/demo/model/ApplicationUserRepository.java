package com.codefellowship.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}
