package com.fundThru.app.eventList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundThru.app.eventList.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u")
	List<User> getAllUsers();
	
	@Query(nativeQuery = true, value ="select * from User u where u.user_id = :userId")
	User findUserById(@Param("userId") Long userId);
	
	@Query(nativeQuery = true, value = "select * from User u where u.email = :email and u.password = :password")
	User authenticateUser(@Param("email")String email, @Param("password") String password);
}
