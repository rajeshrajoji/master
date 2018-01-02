package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.ILoginRepository;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	ILoginRepository loginRepository;

	@Override
	public Boolean validateUser(User user) {
		/*User u=loginRepository.findByUserNameAndUserPassword(user.getUserName(),user.getUserPassword());
		if(u!=null){
		if(u.getUserName().equals(user.getUserName()) && u.getUserPassword().equals(user.getUserPassword()))
		return true;
		}*/
		
		return false;
	}

}
