/**
 * 
 */
package com.anabatic.webee.ws.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.anabatic.webee.ws.dto.CustomUser;
import com.anabatic.webee.ws.security.CustomUsernamePasswordAuthenticationToken;

/**
 * @author muchamad.girinata
 *for get active username or principal
 */
public class UserUtil {
	
	public static void updateAuthentication(CustomUser customUser){
		Authentication prevAuth = getCurrentPrincipal();
		SecurityContextHolder.getContext().setAuthentication(new CustomUsernamePasswordAuthenticationToken(prevAuth.getName(), prevAuth.getCredentials(), prevAuth.getAuthorities(), customUser));
	}	
	
	public static void updateAuthentication(Boolean status){
		Authentication prevAuth = getCurrentPrincipal();
		CustomUser customerUser = ((CustomUser)getCurrentPrincipal().getDetails());
		SecurityContextHolder.getContext().setAuthentication(new CustomUsernamePasswordAuthenticationToken(prevAuth.getName(), prevAuth.getCredentials(), prevAuth.getAuthorities(), customerUser));
	}
	
	public static CustomUser getCustomer(){
		CustomUser customUser = ((CustomUser)getCurrentPrincipal().getDetails());
		return customUser;
	}
	
	public static String getCurrentUsername(){
		String username = getCurrentPrincipal().getName();
		return username;
	}
	
	public static Authentication getCurrentPrincipal(){
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

	public static String getNickname(){
		return getCustomer().getNickname();
	}
	
}
