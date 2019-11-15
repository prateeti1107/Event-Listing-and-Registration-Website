package com.fundThru.app.eventList.service;

import java.util.List;

import com.fundThru.app.eventList.model.UserEvent;

public interface UserEventService {
	
	UserEvent registerUserEvent(UserEvent userEvent);
	
	List<UserEvent> getUserEvent(Long userId);
}
