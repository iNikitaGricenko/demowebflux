package com.inikitagricenko.demo.webflux.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inikitagricenko.demo.webflux.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.inikitagricenko.demo.webflux.entity.UserEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
	private Long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;
	private LocalDate registeredAt;
}