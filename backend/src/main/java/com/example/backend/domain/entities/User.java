package com.example.backend.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class User {
	@Id
	private String email;
	private boolean confirmed;
	private String password;

	private String name;
	@DBRef
	private Family family;

	private LocalDateTime registered;
	private LocalDateTime lastLogin;
	private Role role;

	@JsonIgnore
	private UserSettings settings;
}
