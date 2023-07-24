package com.inikitagricenko.demo.webflux.adapter;

import com.inikitagricenko.demo.webflux.model.User;
import reactor.core.publisher.Mono;

public interface UserInput {

	Mono<Long> save(Mono<User> user);

	Mono<User> update(long id, Mono<User> user);

	Mono<Long> setOnline(Mono<User> user);

	Mono<Long> setOnline(long id);

	Mono<Long> setOnline(String email);

}
