package com.fundThru.app.eventList.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundThru.app.eventList.model.Event;
import com.fundThru.app.eventList.repository.EventRepository;
import com.fundThru.app.eventList.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	EventRepository eventRepository;
	
	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return eventRepository.getAllEvents();
	}

	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		Event e = eventRepository.save(event);
		return e;
	}

	@Override
	public Event findEventById(Long eventId) {
		// TODO Auto-generated method stub
		Event e = eventRepository.findEventById(eventId);
		return e;
	}

	@Override
	public Event searchEventById(Long eventId) {
		// TODO Auto-generated method stub
		Event e = eventRepository.findEventById(eventId);
		return e;
	}

}
