package com.inikitagricenko.demo.webflux.service;

import com.inikitagricenko.demo.webflux.adapter.UserInput;
import com.inikitagricenko.demo.webflux.adapter.UserOutput;
import com.inikitagricenko.demo.webflux.enums.Role;
import com.inikitagricenko.demo.webflux.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserInput userInput;
	private final UserOutput userOutput;

	public long save(User user) {
		user.setRole(Role.USER);
		user.setRegisteredAt(LocalDate.now());
		return userInput.save(user);
	}

	public User update(long id, User user) {
		return userInput.update(id, user);
	}

	public long setOnline(User user) {
		return userInput.setOnline(user);
	}

	public long setOnline(long id) {
		return userInput.setOnline(id);
	}

	public long setOnline(String email) {
		return userInput.setOnline(email);
	}

	public User get(long id) {
		return userOutput.get(id);
	}

	public User get(String email) {
		return userOutput.get(email);
	}

}
