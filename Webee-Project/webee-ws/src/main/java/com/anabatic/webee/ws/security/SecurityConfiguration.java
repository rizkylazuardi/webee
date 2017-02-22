package com.anabatic.webee.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * 
 * @author yuni.ikrima
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	@Autowired
	CustomFailureHandler customFailureHandler;
	@Autowired
    private CustomAuthenticationProvider authenticationProvider;
	/**
	 * 
	 * @param auth
	 * @throws Exception
	 * for checking data username and password with roles of each users
	 */
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    try{
	    	auth.authenticationProvider(authenticationProvider);
	    	auth.eraseCredentials(false);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	 }

	/**
	 * 
	 * @param http
	 * @throws Exception
	 * for redirecting page based on role user login
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http.authorizeRequests()
		.antMatchers("/login").access("permitAll")
		.antMatchers("/resources/**").access("permitAll")
		.antMatchers("/home").access("isAuthenticated()")
		.antMatchers("/**").access("isAuthenticated()")
		
		.and().formLogin().loginPage("/login").loginProcessingUrl("/login").successHandler(customSuccessHandler)
		.failureHandler(customFailureHandler)
		.usernameParameter("username").passwordParameter("password")
		.and().exceptionHandling().accessDeniedPage("/login")
		//.and().tokenRepository(tokenRepository).tokenValiditySeconds(86400)
		.and().csrf();
		
	}

	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}*/
}
