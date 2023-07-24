package com.inikitagricenko.demo.webflux.adapter;

import com.inikitagricenko.demo.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserOutput {

	Mono<User> get(long id);

	Mono<User> get(String email);

	Flux<User> getAll();
}
