package com.inikitagricenko.demo.webflux.controller;

import com.inikitagricenko.demo.webflux.dto.UserRegistration;
import com.inikitagricenko.demo.webflux.mapper.UserMapper;
import com.inikitagricenko.demo.webflux.security.PBKDF2Encoder;
import com.inikitagricenko.demo.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

	private final UserService userService;
	private final PBKDF2Encoder pbkdf2Encoder;
	private final UserMapper userMapper;

	@PostMapping
	public Mono<Long> register(@RequestBody Mono<UserRegistration> userRegistration) {
		return userService.save(userRegistration.map(register -> {
			register.setPassword(pbkdf2Encoder.encode(register.getPassword()));
			return register;
		}).map(userMapper::toUser));
	}

}
