package com.fundThru.app.eventList.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fundThru.app.eventList.dto.UserDTO;
import com.fundThru.app.eventList.model.User;
import com.fundThru.app.eventList.service.UserService;

import org.modelmapper.ModelMapper;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
    public String sayHello() {
        return "hii";
    }
	
	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public List<User> testMethod() {
		
		List<User> users = userService.getAllUsers();
		//System.out.println("users 11111"+ users);
		return users;

	}
	
	@CrossOrigin("http://localhost:3000")
	@RequestMapping(value = "/api/register", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody User addUser(@RequestBody User user, HttpServletResponse response, HttpServletRequest request) {
		System.out.println("FIRST BAME======" + user.getFirstName());
		
		ModelMapper modelMapper = new ModelMapper();
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		User u = null;
		
		try {
			u = userService.addUser(user);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERror");
		}
		
		return u;
	}
	
	@RequestMapping(value = "/api/get-user", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody User authenticateUser(@RequestBody User user,HttpServletResponse response, HttpServletRequest  request) {
		User u = userService.authenticateUser(user.getEmail(), user.getPassword());
		return u;
	}
}
