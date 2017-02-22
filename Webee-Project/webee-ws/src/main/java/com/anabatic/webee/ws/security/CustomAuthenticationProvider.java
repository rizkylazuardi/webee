/**
 * 
 */
package com.anabatic.webee.ws.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.anabatic.webee.exception.WebeeException;

/**
 * @author muchamad.girinata
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication){
		
		try {
			//result = loginManagerRest.getLoginFunction(authentication.getName(), String.valueOf(authentication.getCredentials()));
			//processing login
		} catch (Exception e) {//harusnya webeeException
			throw new UsernameNotFoundException(String.format("User %s does not exist!", authentication.getName()));
		}
		/*if(result.getErrorMessage() != null){
			if((result.getErrorMessage()).contains("6104")){
				throw new UsernameNotFoundException(String.format("User %s is blocked!", authentication.getName()));
			}
			if((result.getErrorMessage()).contains("6111")){
				throw new UsernameNotFoundException(String.format("Too many failed login attempt. Please try again later.", authentication.getName()));
			}
		}
		if(result.getListData() == null || result.getListData().size()==0){
			throw new UsernameNotFoundException(String.format("Invalid username or password!", authentication.getName()));
		}
		if(("RESETED").equals(result.getListData().get(0).get("status"))){
			// TODO : rapih kan ini cuman buat nyobain aja
			String oldPassword = "";
			String username    = "";
			if(result.getListData() != null){
				if(!result.getListData().isEmpty()){
					oldPassword = result.getListData().get(0).containsKey("password")
								  ? (String)result.getListData().get(0).get("password")
							      : "";			  
					username    = result.getListData().get(0).containsKey("username")
							  	  ? (String)result.getListData().get(0).get("username")
								  : "";			  
				}
			}
			
			
			throw new IBPasswordResetedException(String.format("Password was resetted", authentication.getName()), oldPassword,username);
		}
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		CustomUser customUser = new CustomUser();
		CoreUser paramQuery = new CoreUser();
		customUser.setUserID(String.valueOf(result.getListData().get(0).get("id")));
		customUser.setName(String.valueOf(result.getListData().get(0).get("name")));
		//customUser.setStatus(new Boolean(String.valueOf(result.getListData().get(0).get("status"))));
		if(("LIVE").equals(String.valueOf(result.getListData().get(0).get("status")))){
			customUser.setStatus(true);
		}else{
			customUser.setStatus(false);
		}
		
		customUser.setNickname(String.valueOf(result.getListData().get(0).get("nickname")));
		customUser.setProfilePicture(String.valueOf(result.getListData().get(0).get("profilePicture")));
		customUser.setCoverPicture(String.valueOf(result.getListData().get(0).get("coverPicture")));
        customUser.setCif(String.valueOf(result.getListData().get(0).get("reserved01")));
		Map<String, QueryParamDto> param =new HashMap<String, QueryParamDto>();
        param.put("userid", new QueryParamDto("=", authentication.getName(), "AND"));
        paramQuery.setParam(param);
        Authentication auth = null;
        try{
        	coreUserManager.openDB();
        	CoreUser coreUser = coreUserManager.get(paramQuery);
        	if(coreUser==null){
        		coreUser = new CoreUser();
        		coreUser.setUserid(authentication.getName());
        		coreUser.setIsLogin(1);
        		coreUser.setIsActive(1);
        		coreUserManager.insert(coreUser);
        		customUser.setIsFirst(true);
        	}else{
        		coreUser.setIsLogin(1);
        		coreUserManager.insert(coreUser);
        		customUser.setShowBalance(coreUser.getShowBalance() == null?false:coreUser.getShowBalance());
        		customUser.setLanguage(coreUser.getLanguage()==null?"en":coreUser.getLanguage());
        	}
        	auth = new CustomUsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authList, customUser);
        }catch(Exception e){
        	throw new UsernameNotFoundException(String.format("User %s does not exist!", authentication.getName()));
        }*/
		Authentication auth = null;
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
