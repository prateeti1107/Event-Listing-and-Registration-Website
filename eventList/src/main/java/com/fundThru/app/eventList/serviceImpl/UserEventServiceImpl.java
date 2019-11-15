package com.fundThru.app.eventList.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundThru.app.eventList.model.UserEvent;
import com.fundThru.app.eventList.repository.UserEventRepository;
import com.fundThru.app.eventList.service.UserEventService;

@Service
public class UserEventServiceImpl implements UserEventService{

	@Autowired
	UserEventRepository userEventRepository;
	
	@Override
	public UserEvent registerUserEvent(UserEvent userEvent) {
		// TODO Auto-generated method stub
		UserEvent ue = userEventRepository.save(userEvent);
		return ue;
	}

	@Override
	public List<UserEvent> getUserEvent(Long userId) {
		// TODO Auto-generated method stub
		//List<UserEvent> userEvents = new ArrayList<UserEvent>();
		return userEventRepository.getUserEvent(userId);
	}

}
