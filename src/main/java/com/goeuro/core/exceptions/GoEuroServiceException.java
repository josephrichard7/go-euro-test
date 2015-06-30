package com.goeuro.core.exceptions;

public class GoEuroServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoEuroServiceException() {
	}
	
	public GoEuroServiceException(Throwable cause) {
		super(cause);
	}

	public GoEuroServiceException(String message) {
		super(message);
	}
	
	public GoEuroServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
