package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.UserServiceInterface;
import com.example.entity.User;

import org.springframework.ui.Model; 
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	 @Autowired
	 private UserServiceInterface userService;
	 
	// Show registration form
	    @GetMapping("/register")
	    public String showRegisterForm(Model model) {
	        model.addAttribute("user", new User());
	        return "register";
	    }

	    // Handle registration
	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute("user") User user, Model model) {
	        if (userService.userExistsByEmail(user.getEmail())) {
	            model.addAttribute("error", "Email already exists!");
	            return "register";
	        }
	        userService.registerUser(user);
	        return "redirect:/login";
	    }

	    // Show login form
	    @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("user", new User());
	        return "login";
	    }

	    // Handle login
	    @PostMapping("/login")
	    public String loginUser(@ModelAttribute("user") User user, HttpSession session, Model model) {
	        User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
	        if (loggedInUser != null) {
	            session.setAttribute("loggedInUser", loggedInUser);
	            return "redirect:/welcome";
	        } else {
	            model.addAttribute("error", "Invalid username or password");
	            return "login";
	        }
	    }

	    // Show welcome page
	    @GetMapping("/welcome")
	    public String showWelcomePage() {
	        return "welcome";
	    }

	    // Optional: logout
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
}

