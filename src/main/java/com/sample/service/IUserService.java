package com.sample.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sample.model.AccessToken;
import com.sample.model.User;


public interface IUserService extends UserDetailsService {

	User findUserByAccessToken(String accessToken);

	AccessToken createAccessToken(User user);
}
