package com.inikitagricenko.demo.webflux.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@RequiredArgsConstructor
public class UserAuthority implements GrantedAuthority {

	private final String authority;

}
