package com.inikitagricenko.demo.webflux.repository;

import com.inikitagricenko.demo.webflux.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

	Mono<UserEntity> findByEmail(String email);

}