package com.fundThru.app.eventList.service;

import java.util.List;

import com.fundThru.app.eventList.model.Event;

public interface EventService {

	List<Event> getAllEvents();
	
	Event addEvent(Event event);
	
	Event findEventById(Long eventId);
	
	Event searchEventById(Long eventId);
	
	//Event registerEvent(Event event);
}
