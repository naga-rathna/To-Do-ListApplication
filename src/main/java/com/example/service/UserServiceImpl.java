package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {
	@Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Optional: Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return null; // or throw exception
        }
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}

