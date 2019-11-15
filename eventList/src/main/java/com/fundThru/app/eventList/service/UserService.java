package com.fundThru.app.eventList.service;

import java.util.List;

import com.fundThru.app.eventList.model.User;

public interface UserService {

	List<User> getAllUsers();
	User addUser(User user);
	User findUserById(Long userId);
	User authenticateUser(String email, String password);
}
