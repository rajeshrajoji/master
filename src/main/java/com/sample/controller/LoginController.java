package com.sample.controller;

import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.model.AccessToken;
import com.sample.model.ReportDetails;
import com.sample.model.User;
import com.sample.repository.IReportDetailsRepository;
import com.sample.service.ILoginService;
import com.sample.service.IUserService;


@RestController
@RequestMapping("/fcmapp/api/v1/user")
public class LoginController {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	
	  @Autowired
	private IUserService userService;

	@Autowired
	ILoginService loginService;

	@Autowired
	IReportDetailsRepository reportDetailsRepository;

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	//@POST
	public  @ResponseBody AccessToken validateUser(@RequestBody User user,
			UriComponentsBuilder ucBuilder) {
		String username=user.getUsername();
		String password=user.getPassword();
		System.out.println("usr name"+username+"********password"+username);
		
		UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Object principal = authentication.getPrincipal();
        System.out.println("principal"+principal.getClass());
        if (!(principal instanceof User)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);            
        }
        return this.userService.createAccessToken((User) principal);
	}

	

}
