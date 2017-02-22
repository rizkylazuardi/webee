/**
 * 
 */
package com.anabatic.webee.exception;

import java.util.HashMap;





public class WebeeException extends GenericException {
	
	private static final long serialVersionUID = 1L;
	private int errorType;
	
	public WebeeException(Throwable throwable) {
		super(throwable);
	}

	public WebeeException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public WebeeException(String message) {
		super(message);
	}
	
	public WebeeException(HashMap<String, Object> prop) {
		super(prop);
	}
	
	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

}
