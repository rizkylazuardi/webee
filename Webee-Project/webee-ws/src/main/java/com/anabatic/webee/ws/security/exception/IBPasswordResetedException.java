package com.anabatic.webee.ws.security.exception;

import org.springframework.security.core.AuthenticationException;

public class IBPasswordResetedException extends AuthenticationException {

	private String oldPassword;
	private String username;
	
	public IBPasswordResetedException(String msg) {
		super(msg);
	}

	

	public IBPasswordResetedException(String msg, String oldPassword, String username) {
		super(msg);
		this.oldPassword = oldPassword;
		this.username = username;
	}



	public String getOldPassword() {
		return oldPassword;
	}



	public String getUsername() {
		return username;
	}
	
	

}
