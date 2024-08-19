package com.springs.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springs.practice.model.User;

@ControllerAdvice
public class UserExceptionHandler {

	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> getMessage(UserNotFoundException userNotFoundException) {
		UserException userException = new UserException(userNotFoundException.getMessage());
		return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
	}
}
