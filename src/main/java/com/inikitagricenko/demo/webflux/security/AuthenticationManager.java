package com.inikitagricenko.demo.webflux.security;

import com.inikitagricenko.demo.webflux.model.User;
import com.inikitagricenko.demo.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

	private final UserService userService;
	private final JwtSigner jwtSigner;

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		return Mono.just(authentication)
				.map(auth -> jwtSigner.validate(auth.getCredentials().toString()))
				.onErrorStop()
				.map(jws -> userService.get(jws.getBody().getSubject()))
				.flatMap(user -> getAuthority(user, authentication));
	}

	private Mono<Authentication> getAuthority(Mono<User> userMono, Authentication authentication) {
		return userMono.map(user -> getAuthority(user, authentication));
	}

	private Authentication getAuthority(User user, Authentication authentication) {
		return new UsernamePasswordAuthenticationToken(user.getEmail(), authentication.getCredentials(), List.of(new UserAuthority(user.getRole().getRoleName())));
	}
}
