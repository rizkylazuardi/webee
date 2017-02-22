/**
 * 
 */
package com.anabatic.webee.ws.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.anabatic.webee.ws.dto.CustomUser;

/**
 * @author muchamad.girinata
 *
 */
public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomUsernamePasswordAuthenticationToken(Object principal,
			Object credentials,
			Collection<? extends GrantedAuthority> authorities, CustomUser customUser) {
		super(principal, credentials, authorities);
		setDetails(customUser);
	}
	
	public CustomUsernamePasswordAuthenticationToken(Object principal,
			Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	@Override
	public void setDetails(Object details) {
		super.setDetails(details);
	}

	
}
