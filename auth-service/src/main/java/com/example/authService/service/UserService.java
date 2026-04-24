package com.example.authService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authService.entity.User;
import com.example.authService.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	public User register(User user) {

		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		return repo.save(user);

	}
}
