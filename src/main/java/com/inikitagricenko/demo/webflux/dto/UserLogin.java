package com.inikitagricenko.demo.webflux.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inikitagricenko.demo.webflux.entity.UserEntity;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserLogin(String email, String password) implements Serializable {
}