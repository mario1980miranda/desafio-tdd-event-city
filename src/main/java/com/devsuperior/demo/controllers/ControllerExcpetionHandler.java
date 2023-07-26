package com.devsuperior.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExcpetionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Void> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		final HttpStatus status = HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).build();
	}
}
