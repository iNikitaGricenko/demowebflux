package com.inikitagricenko.demo.webflux.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.inikitagricenko.demo.webflux.entity.UserEntity}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistration implements Serializable {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
}