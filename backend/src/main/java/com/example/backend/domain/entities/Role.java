package com.example.backend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.example.backend.common.Constants.ROLE_ADMINISTRATOR;
import static com.example.backend.common.Constants.ROLE_OBSERVER;
import static com.example.backend.common.Constants.ROLE_SYSTEM;
import static com.example.backend.common.Constants.ROLE_USER;

@AllArgsConstructor
@Getter
public enum Role {
	SYSTEM(ROLE_SYSTEM),
	ADMIN(ROLE_ADMINISTRATOR),
	USER(ROLE_USER),
	OBSERVER(ROLE_OBSERVER);

	private final String name;
}
