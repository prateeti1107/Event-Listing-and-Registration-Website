package com.fundThru.app.eventList.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundThru.app.eventList.model.User;
import com.fundThru.app.eventList.repository.UserRepository;
import com.fundThru.app.eventList.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User u = null;
		try {
//			String password = user.getPassword();
//			DESEncryptDecrypt des = new DESEncryptDecrypt();
//			String encryptedPass = des.encryptValue(password);
//			user.setPassword(encryptedPass);
			u = userRepository.save(user); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		User u = userRepository.findUserById(userId);
		return u;
	}

	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		User u = userRepository.authenticateUser(email, password);
		return u;
	}

}
