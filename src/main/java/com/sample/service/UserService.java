package com.sample.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.model.AccessToken;
import com.sample.model.User;
import com.sample.repository.IAccessTokenRepository;
import com.sample.repository.IUserRepository;

@Service("userService")
public class UserService implements IUserService
{
	
    private IUserRepository userDao;

	
    private IAccessTokenRepository accessTokenDao;

	@Autowired
    public UserService(@Qualifier("userDao") IUserRepository userDao, @Qualifier("accessTokenDao") IAccessTokenRepository accessTokenDao) {
		super();
		this.userDao = userDao;
		this.accessTokenDao = accessTokenDao;
	}


	@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userDao.findByName(username);
    }

 
    @Override
    @Transactional
    public AccessToken createAccessToken(User user)
    {
        AccessToken accessToken = new AccessToken(user, UUID.randomUUID().toString());
        return accessTokenDao.save(accessToken);
    }

	@Override
	@Transactional
	public User findUserByAccessToken(String accessTokenString) {

        AccessToken accessToken = accessTokenDao.findByToken(accessTokenString);

        if (null == accessToken) {
            return null;
        }

        if (accessToken.isExpired()) {
             accessTokenDao.delete(accessToken);
            return null;
        }

        return accessToken.getUser();
	}

}
	