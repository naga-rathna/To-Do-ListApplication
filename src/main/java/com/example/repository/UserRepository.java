package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 // Custom method to find user by email and password for login
    User findByEmailAndPassword(String email, String password);

    // Optional: Find by email (can help during registration to check for duplicates)
    User findByEmail(String email);
}

