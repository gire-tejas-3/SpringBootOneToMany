package com.springs.practice.exception;

public class UserException {

	private String message;

	public UserException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
