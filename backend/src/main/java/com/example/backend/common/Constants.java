package com.example.backend.common;

public class Constants {
	public static final String AUTHENTICATION_PATH = "/api/auth";
	public static final String REGISTRATION_PATH = "/registration";
	public static final String LOGIN_PATH = "/login";

	public static final String[] SWAGER_AUTH_WHITELIST = {
			"/v2/api-docs",
			"/v3/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger-ui/**",
			"/webjars/**"
	};
	public static final String[] LOGIN_AUTH_WHITELIST = {
			AUTHENTICATION_PATH + REGISTRATION_PATH,
			AUTHENTICATION_PATH + LOGIN_PATH
	};
	public static final String[] SOCIAL_LOGIN_AUTH_WHITELIST = {
			// todo delete / and //sizeoffbackend
			"/",
			"/sizeoffbackend/**",                          // delete - for test
			"/login/oauth2/code/**",
	};

	public static final String ROLE_SYSTEM = "ROLE_SYSTEM";
	public static final String ROLE_ADMINISTRATOR = "ROLE_ADMINISTRATOR";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_OBSERVER = "ROLE_OBSERVER";
	public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	public static final String ACCESS_ANONYMOUS = "hasRole('" + ROLE_ANONYMOUS + "')";
	public static final String ACCESS_OBSERVER = "hasRole('" + ROLE_OBSERVER + "')";
	public static final String ACCESS_USER = "hasRole('" + ROLE_USER + "') or hasRole('" + ROLE_OBSERVER + "')";
	public static final String ACCESS_ADMINISTRATOR = "hasRole('" + ROLE_ADMINISTRATOR + "') or hasRole('" + ROLE_USER + "') or hasRole('" + ROLE_OBSERVER + "')";
	public static final String ACCESS_SYSTEM_ADMINISTRATOR = "hasRole('" + ROLE_SYSTEM + "')";
}
