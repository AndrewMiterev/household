package com.example.backend.common;

import com.example.backend.domain.entities.Role;

public interface Constants {
	String AUTHENTICATION_PATH = "/api/auth";
	String REGISTRATION_PATH = "/registration";
	String LOGIN_PATH = "/login";

	String[] SWAGER_AUTH_WHITELIST = {
			"/v2/api-docs",
			"/v3/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger-ui/**",
			"/webjars/**"
	};
	String[] LOGIN_AUTH_WHITELIST = {
			AUTHENTICATION_PATH + REGISTRATION_PATH,
			AUTHENTICATION_PATH + LOGIN_PATH
	};
	String[] SOCIAL_LOGIN_AUTH_WHITELIST = {
			// todo delete / and //sizeoffbackend
			"/",
			"/sizeoffbackend/**",                          // delete - for test
			"/login/oauth2/code/**",
	};

	String HAS_ROLE = "hasRole('";
	String ROLE_END = "')";
	String OR = ROLE_END + " or ";
	String ACCESS_ANONYMOUS = HAS_ROLE + "ROLE_ANONYMOUS" + ROLE_END;
	String ACCESS_OBSERVER = HAS_ROLE + Role.ROLE_OBSERVER.name() + ROLE_END;
	String ACCESS_USER = HAS_ROLE + Role.ROLE_USER.name() + OR + HAS_ROLE + Role.ROLE_OBSERVER.name() + ROLE_END;
	String ACCESS_ADMINISTRATOR = HAS_ROLE + Role.ROLE_ADMINISTRATOR.name() + OR + HAS_ROLE + Role.ROLE_USER.name() + OR + HAS_ROLE + Role.ROLE_OBSERVER.name() + ROLE_END;
	String ACCESS_SYSTEM_ADMINISTRATOR = HAS_ROLE + Role.ROLE_SYSTEM.name() + ROLE_END;
}
