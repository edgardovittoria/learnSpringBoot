package com.manning.readingList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manning.readingList.domain.User;
import com.manning.readingList.repository.UserRepository;



@Controller
@RequestMapping("/newUser")
public class SigninController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	
	@PostMapping("/signin")
	public String addUser(User user) {
		String pwd = user.getPassword();
		String encriptPwdString = passwordEncoder.encode(pwd);
		user.setPassword(encriptPwdString);
		userRepository.save(user);
		return "redirect:/"+user.getUsername();
	}
}
