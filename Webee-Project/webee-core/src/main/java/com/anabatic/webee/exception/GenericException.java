package com.anabatic.webee.exception;

import java.util.HashMap;

public class GenericException extends Exception {

	private static final long serialVersionUID = 3953606583860832790L;

	private String errorCode;
	private String errorKey;
	private HashMap<String, Object> properties ;
	
	public GenericException(String message) {
        super(message);
    }

	public GenericException(Throwable throwable) {
		super(throwable);
	}
	
    public GenericException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public GenericException(HashMap<String, Object> prop) {
		this.properties = prop;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}
	
	
    
}
