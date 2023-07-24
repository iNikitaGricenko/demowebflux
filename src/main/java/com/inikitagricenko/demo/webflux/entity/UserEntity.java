package com.inikitagricenko.demo.webflux.entity;

import com.inikitagricenko.demo.webflux.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "`user`")
@Getter @Setter
@SQLDelete(sql = "UPDATE user e " +
        "SET deleted=true, deleted_at=now() " +
        "WHERE e.user_id=?")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "registered_at")
	private LocalDate registeredAt;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "online_at")
	private LocalDateTime onlineAt;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

}
