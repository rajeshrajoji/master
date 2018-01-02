package com.sample.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.User;

@Repository("userDao")
public interface IUserRepository extends CrudRepository<User, Serializable> {
	User findByName(String name);	
}
