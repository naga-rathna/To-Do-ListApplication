package com.example.service;

import com.example.entity.User;

public interface UserServiceInterface {
	 User registerUser(User user);
	 User loginUser(String email, String password);
	 boolean userExistsByEmail(String email);
}

