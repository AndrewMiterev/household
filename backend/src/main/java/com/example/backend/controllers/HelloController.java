package com.example.backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backend.common.Constants.ACCESS_ANONYMOUS;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("hello")
@CrossOrigin(origins = "*")
@Validated
public class HelloController {
	@PreAuthorize(ACCESS_ANONYMOUS)
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Say Hellow!")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden")
	})
	public String sayHellow() {
		return "Hellow!";
	}
}
