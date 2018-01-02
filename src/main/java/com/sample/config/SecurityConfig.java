package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.sample.service.AuthenticationTokenProcessingFilter;
import com.sample.service.IUserService;
import com.sample.service.UnauthorizedEntryPoint;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Autowired
	IUserService userService;

	@Autowired
	AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter;

	@Bean(name = "authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new UnauthorizedEntryPoint();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());;
		//auth.inMemoryAuthentication().passwordEncoder(passwordEncoder());
		super.configure(auth);
	}
	

	@Bean
	public IUserService authenticator() {
		return userService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	//	http.authorizeRequests().antMatchers("/rest/user/authenticate").authenticated().antMatchers("/**").permitAll();
		http.authorizeRequests().antMatchers("/fcmapp/api/v1/user/loginUser").permitAll();
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
		http.addFilterAt(authenticationTokenProcessingFilter, AbstractPreAuthenticatedProcessingFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

}
