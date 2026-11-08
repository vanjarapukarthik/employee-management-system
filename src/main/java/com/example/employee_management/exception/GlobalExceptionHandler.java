package com.example.employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.dao.EmptyResultDataAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFound(EmptyResultDataAccessException ex) {
	    return "Employee not found";
	}
}