package com.jwa.exception;

/**
 * 
 * @author John Anderson
 * 
 * Custom error for api
 */
public class ApiError extends RuntimeException {

	public ApiError(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ApiError(String arg0) {
		super(arg0);
	}

	public ApiError(Throwable arg0) {
		super(arg0);
	}

	
}
