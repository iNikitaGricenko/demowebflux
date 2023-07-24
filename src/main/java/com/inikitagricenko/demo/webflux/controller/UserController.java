package com.inikitagricenko.demo.webflux.controller;

import com.inikitagricenko.demo.webflux.dto.UserResponse;
import com.inikitagricenko.demo.webflux.mapper.UserMapper;
import com.inikitagricenko.demo.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserMapper userMapper;

	@GetMapping("/{id}")
	public Mono<UserResponse> getUserById(@PathVariable("id") long id) {
		return userService.get(id).map(userMapper::toResponse);
	}

	@GetMapping
	public Flux<UserResponse> getAllUsers() {
		return userService.getAll().map(userMapper::toResponse);
	}

}
