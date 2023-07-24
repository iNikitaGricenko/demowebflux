package com.inikitagricenko.demo.webflux.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inikitagricenko.demo.webflux.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.inikitagricenko.demo.webflux.entity.UserEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse implements Serializable {
	String email;
	String firstName;
	String lastName;
	Role role;
	LocalDate registeredAt;
}