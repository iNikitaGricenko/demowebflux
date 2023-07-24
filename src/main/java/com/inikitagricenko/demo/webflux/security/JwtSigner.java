package com.inikitagricenko.demo.webflux.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtSigner {

	private final static KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

	public String create(String email) {
		return Jwts.builder()
				.signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256)
				.setSubject(String.valueOf(email))
				.setIssuer("identity")
				.setExpiration(Date.from(Instant.now().plus(Duration.ofMinutes(20))))
				.setIssuedAt(Date.from(Instant.now()))
				.compact();
	}

	public Jws<Claims> validate(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(keyPair.getPublic())
				.build()
				.parseClaimsJws(token);
	}

}
