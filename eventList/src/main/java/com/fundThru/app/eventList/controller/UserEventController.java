package com.fundThru.app.eventList.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundThru.app.eventList.model.Event;
import com.fundThru.app.eventList.model.User;
import com.fundThru.app.eventList.model.UserEvent;
import com.fundThru.app.eventList.repository.UserEventRepository;
import com.fundThru.app.eventList.service.EventService;
import com.fundThru.app.eventList.service.UserEventService;
import com.fundThru.app.eventList.service.UserService;


@RestController
@RequestMapping("/userEvent")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UserEventController {

	@Autowired
	UserEventService userEventService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "/registerUserEvent", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody UserEvent registerUserEvent(@RequestBody JsonNode objNode, HttpServletResponse response, HttpServletRequest request) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String tempUserId = objNode.get("userId").toString();
		//long userId = Integer.parseInt(tempUserId.substring(1, tempUserId.length()-1));
		long userId = Integer.parseInt(tempUserId);
		
		String tempEventId = objNode.get("eventId").toString();
		long eventId = Integer.parseInt(tempEventId);
		
		System.out.println("USER ID ----" + userId + "   EVENT ID===="+ eventId);
		
		User user = userService.findUserById(userId);
		Event event = eventService.findEventById(eventId);
		
		UserEvent tempUE = new UserEvent();
		tempUE.setEvent(event);
		tempUE.setUser(user);
		
		UserEvent ue = userEventService.registerUserEvent(tempUE);
		return ue;
	}
	
	@RequestMapping(value = "/userRegEvent/{userId}", method = RequestMethod.GET)
	public List<UserEvent> getUserEvents(@PathVariable("userId")Long userId) {
		
		List<UserEvent> usersEvents = userEventService.getUserEvent(userId);
		for (int i=0; i<usersEvents.size();i++) {
			System.out.println("users events ########"+ usersEvents.get(i).getEvent().getEventId());
		}
		
		return usersEvents;

	}
}
