package com.arpit.jsr.exception.handler;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map handle(MethodArgumentNotValidException exception) {
		return error(exception.getBindingResult().getFieldErrors().stream()
				.map(FieldError::getDefaultMessage)
				.collect(Collectors.toList()));
	}

	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map handle(ConstraintViolationException exception) {
		return error(exception.getConstraintViolations().stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.toList()));
	}

	@SuppressWarnings("rawtypes")
	private Map error(Object message) {
		return Collections.singletonMap("error", message);
	}
}
