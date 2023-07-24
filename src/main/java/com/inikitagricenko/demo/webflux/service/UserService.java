package com.inikitagricenko.demo.webflux.service;

import com.inikitagricenko.demo.webflux.adapter.UserInput;
import com.inikitagricenko.demo.webflux.adapter.UserOutput;
import com.inikitagricenko.demo.webflux.enums.Role;
import com.inikitagricenko.demo.webflux.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserInput userInput;
	private final UserOutput userOutput;

	public Mono<Long> save(Mono<User> user) {
		return userInput.save(
				user.map(it -> {
					it.setRole(Role.USER);
					it.setRegisteredAt(LocalDate.now());
					return it;
				}));
	}

	public Mono<User> update(long id, Mono<User> user) {
		return userInput.update(id, user);
	}

	public Mono<Long> setOnline(Mono<User> user) {
		return userInput.setOnline(user);
	}

	public Mono<Long> setOnline(long id) {
		return userInput.setOnline(id);
	}

	public Mono<Long> setOnline(String email) {
		return userInput.setOnline(email);
	}

	public Mono<User> get(long id) {
		return userOutput.get(id);
	}

	public Mono<User> get(String email) {
		return userOutput.get(email);
	}

	public Flux<User> getAll() {
		return userOutput.getAll();
	}

}
