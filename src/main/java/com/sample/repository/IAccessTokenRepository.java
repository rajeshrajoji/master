package com.sample.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.AccessToken;

@Repository("accessTokenDao")
public interface IAccessTokenRepository extends CrudRepository<AccessToken, Serializable> {
	 AccessToken findByToken(String accessTokenString);

}
