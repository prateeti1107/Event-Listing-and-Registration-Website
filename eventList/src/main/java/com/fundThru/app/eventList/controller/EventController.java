package com.fundThru.app.eventList.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.fundThru.app.eventList.model.EventImage;
import com.fundThru.app.eventList.model.User;
import com.fundThru.app.eventList.model.UserEvent;
import com.fundThru.app.eventList.service.EventImageService;
import com.fundThru.app.eventList.service.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	EventImageService eventImageService;
	
	@RequestMapping(value = "/getEvents", method = RequestMethod.GET)
	public List<Event> getAllEvents() {
		
		List<Event> users = eventService.getAllEvents();
		//System.out.println("users 11111"+ users);
		return users;

	}
	
//	@RequestMapping(value = "/addEvent", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
//	public @ResponseBody Event addEvent(@RequestBody Event event, HttpServletResponse response, HttpServletRequest request) {
//		//System.out.println("FIRST BAME======" + event.getFirstName());
//		Event e = eventService.addEvent(event);
//		return e;
//	}
	
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public @ResponseBody Event addEvent(@RequestBody JsonNode objNode, HttpServletResponse response, HttpServletRequest request) {
		Event event = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			
			String tempPicId = objNode.get("picId").toString();
			
			String tempEventName = objNode.get("eventName").toString();
			tempEventName = tempEventName.substring(1, tempEventName.length()-1);
			
			String tempEventDesc = objNode.get("eventDescription").toString();
			tempEventDesc = tempEventDesc.substring(1, tempEventDesc.length()-1);
			
			String tempEventStart = objNode.get("eventStart").toString();
			tempEventStart = tempEventStart.substring(1, tempEventStart.length()-1);
			
			java.util.Date testDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(tempEventStart);
			
			java.sql.Date sqlDt1 = new java.sql.Date(testDate1.getTime());
			
			System.out.println("Hoo" + sqlDt1);
			
			String tempEventEnd = objNode.get("eventEnd").toString();
			
			java.util.Date testDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(tempEventStart);
			
			java.sql.Date sqlDt2 = new java.sql.Date(testDate2.getTime());
			
			long picId = Integer.parseInt(tempPicId);
			//Date date1=Date.valueOf(tempEventStart);	
			
			
			//Date date2 = Date.valueOf(tempEventEnd);
			EventImage picture = eventImageService.getPicture(picId);
			
			Event tempEvent = new Event();
			tempEvent.setEventImage(picture);
			tempEvent.setEventName(tempEventName);
			tempEvent.setEventDescription(tempEventDesc);
			tempEvent.setEventStart(sqlDt1);
			tempEvent.setEventEnd(sqlDt2);
			
			event = eventService.addEvent(tempEvent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}
	
	@RequestMapping(value = "/searchEvent/{eventId}", method = RequestMethod.GET, produces = "application/json")
	public Event getEvent(@PathVariable("eventId") Long eventId) {
		Event event = eventService.searchEventById(eventId);
		
		return event;
	}
	
	
}
