package com.inikitagricenko.demo.webflux.controller;

import com.inikitagricenko.demo.webflux.dto.UserResponse;
import com.inikitagricenko.demo.webflux.mapper.UserMapper;
import com.inikitagricenko.demo.webflux.model.User;
import com.inikitagricenko.demo.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserMapper userMapper;

	@GetMapping("/{id}")
	public Mono<UserResponse> getUserById(@PathVariable("id") long id) {
		User user = userService.get(id);
		UserResponse response = userMapper.toResponse(user);
		return Mono.just(response);
	}

	@GetMapping
	public Flux<UserResponse> getAllUsers() {
		return Flux.empty();
	}

}
