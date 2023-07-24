package com.inikitagricenko.demo.webflux.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final ReactiveAuthenticationManager authenticationManager;
	private final ServerSecurityContextRepository contextRepository;

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.exceptionHandling()
				.authenticationEntryPoint((swe, e) ->
						Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)))
				.accessDeniedHandler((swe, e) ->
						Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN)))
				.and()
				.csrf().disable()
				.httpBasic().disable()
				.formLogin().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(contextRepository)
				.authorizeExchange()
				.pathMatchers("/login").permitAll()
				.pathMatchers("/register").permitAll()
				.anyExchange().authenticated()
				.and().build();
	}

}
