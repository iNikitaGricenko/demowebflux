package com.inikitagricenko.demo.webflux.controller;

import com.inikitagricenko.demo.webflux.dto.UserRegistration;
import com.inikitagricenko.demo.webflux.mapper.UserMapper;
import com.inikitagricenko.demo.webflux.model.User;
import com.inikitagricenko.demo.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/register")
@RequiredArgsConstructor
public class RegisterController {

	private final UserService userService;
	private final UserMapper userMapper;

	@PostMapping
	public Mono<Long> register(@RequestBody UserRegistration userRegistration) {
		User user = userMapper.toUser(userRegistration);
		long save = userService.save(user);
		return Mono.just(save);
	}

}
