package com.example.backend.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorsController {
	/*
		@ExceptionHandler(BindException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorDTO<String> handleBindExceptionError(BindException exception) {
			log.debug(String.format("User bind exception error: %s", exception.getMessage()));
			return ErrorDTO.<String>builder()
					.error("Not valid arguments for method")
					.status(HttpStatus.BAD_REQUEST.value())
					.errors(
							exception.getFieldErrors()
									.stream()
									.map(e -> ErrorLineDTO.builder()
											.rejectedField(e.getField())
											.errorMessage(e.getDefaultMessage())
											.rejectedValue((String) e.getRejectedValue())
											.build())
									.collect(Collectors.toList())
					)
					.build();
		}

		@ExceptionHandler(ConstraintViolationException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorDTO<String> handleConstraintViolationError(ConstraintViolationException exception) {
			log.debug(String.format("User constraint violation error: %s", exception.getMessage()));
			return ErrorDTO.<String>builder()
					.error("Not valid arguments for method")
					.status(HttpStatus.BAD_REQUEST.value())
					.errors(
							exception.getConstraintViolations()
									.stream()
									.map(e -> ErrorLineDTO.builder()
											.rejectedField(e.getPropertyPath().toString())
											.rejectedValue(e.getInvalidValue() == null ? "null" : e.getInvalidValue().toString())
											.errorMessage(e.getMessage())
											.build())
									.collect(Collectors.toList())
					)
					.build();
		}

		@ExceptionHandler(MissingServletRequestParameterException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorDTO<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
			log.debug("MissingServletRequestParameterException error: {}", exception.getMessage());
			return ErrorDTO.<String>builder()
					.error("missing requested parameter: %s".formatted(exception.getParameterName()))
					.status(HttpStatus.BAD_REQUEST.value())
					.build();
		}

		@ExceptionHandler({UnauthorizedException.class, AuthenticationException.class, BadCredentialsException.class})
		@ResponseStatus(HttpStatus.UNAUTHORIZED)
		public ErrorDTO<String> handleUnauthorizedException(Exception exception) {
			log.warn(exception.getMessage());
			return ErrorDTO.<String>builder()
					.error(exception.getMessage())
					.status(HttpStatus.UNAUTHORIZED.value())
					.build();
		}

		@ExceptionHandler({ForbiddenException.class, AccessDeniedException.class})
		@ResponseStatus(HttpStatus.FORBIDDEN)
		public ErrorDTO<String> handleForbiddenException(Exception exception) {
			log.warn(exception.getMessage());
			return ErrorDTO.<String>builder()
					.error(exception.getMessage())
					.status(HttpStatus.FORBIDDEN.value())
					.build();
		}

		@ExceptionHandler({NonCriticException.class, HttpRequestMethodNotSupportedException.class})
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorDTO<String> handleNonCriticException(Exception exception) {
			log.warn(exception.getMessage());
			return ErrorDTO.<String>builder()
					.error(exception.getMessage())
					.status(HttpStatus.BAD_REQUEST.value())
					.build();
		}


		@ExceptionHandler(RuntimeException.class)
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		public ErrorDTO<String> handleRuntimeErrors(Exception exception) {
			log.error("Run time error: {} {}", exception.getClass().getName(), exception.getMessage());
			return ErrorDTO.<String>builder()
					.error(exception.getMessage())
					.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.build();
		}
	*/

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleOtherErrors(Exception exception) {
		String error = String.format("Unsupported common exception. Name: (%s) Message: (%s)", exception.getClass().getName(), exception.getMessage());
		log.error(error);
		exception.printStackTrace();
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
