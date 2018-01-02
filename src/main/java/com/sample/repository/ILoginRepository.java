package com.sample.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.model.User;

@Repository
public interface ILoginRepository extends CrudRepository<User, Serializable>
{
   
    @Query(
            value = "SELECT * FROM user_Details t where t.user_Name = :userName AND t.user_Password = :userPassword", 
            nativeQuery=true
        )
	User findByUserNameAndUserPassword(@Param("userName") String userName, 
            @Param("userPassword") String userPassword);


}
