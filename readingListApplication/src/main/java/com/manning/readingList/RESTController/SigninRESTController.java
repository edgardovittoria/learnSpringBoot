package com.manning.readingList.RESTController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manning.readingList.domain.User;
import com.manning.readingList.repository.UserRepository;

@RestController
@RequestMapping("/rest/newUser")
public class SigninRESTController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
	public void addUser(@RequestBody User user) {
		String encodePWD = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePWD);
		userRepository.save(user);
		
	}
}
