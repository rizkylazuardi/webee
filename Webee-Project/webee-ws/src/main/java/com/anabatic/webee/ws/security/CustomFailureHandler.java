package com.anabatic.webee.ws.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.anabatic.webee.ws.security.exception.IBPasswordResetedException;


@Component
public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	private static final String HASH_HEADER_PARAM = "Xyxy";
	private static final String USERNAME_HEADER_PARAM = "ktyk";
	
	/*public CustomFailureHandler() {
		//this.setDefaultFailureUrl("/login");
		//this.setUseForward(false);
		super();
	}*/
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
			HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		// some logic here..
		
		if(exception instanceof IBPasswordResetedException){
			IBPasswordResetedException ibPasswordResetedException = (IBPasswordResetedException)exception;
	
			redirectStrategy.sendRedirect(request, response, "/registration/forceChangePassword?"+USERNAME_HEADER_PARAM+"="+ibPasswordResetedException.getUsername()+"&"+HASH_HEADER_PARAM+"="+ibPasswordResetedException.getOldPassword());
			return ; // biar code gg ngelanjut ke bawah
		}
		
		System.out.println(exception.getMessage());
		if(("RESETED").equals(exception.getMessage())){
			redirectStrategy.sendRedirect(request, response, "/registration/forceChangePassword");
		}else{
			saveException(request, exception);
			redirectStrategy.sendRedirect(request, response, "/login?error");
		}
	}
	
	/*@Override
	 public void onAuthenticationFailure(HttpServletRequest request,
	   HttpServletResponse response, AuthenticationException exception)
	   throws IOException, ServletException {
	  
	  response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	    "Authentication Failed: " + exception.getMessage());
	  
	  //getRedirectStrategy().sendRedirect(request, response, "/login");
	  
	 }*/
}
