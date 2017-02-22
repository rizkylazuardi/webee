package com.anabatic.webee.ws.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author muchamad.girinata
 *
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		Authentication authResult = super.attemptAuthentication(request, response);
		
		return authResult;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            javax.servlet.FilterChain chain,
            Authentication authResult)
            		throws IOException,ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		
	}
	
	@Override
	protected void unsuccessfulAuthentication(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            AuthenticationException failed)
     throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
	}
}
