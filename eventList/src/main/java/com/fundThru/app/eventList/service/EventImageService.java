package com.fundThru.app.eventList.service;

import org.springframework.web.multipart.MultipartFile;

import com.fundThru.app.eventList.model.Event;
import com.fundThru.app.eventList.model.EventImage;

public interface EventImageService {

	EventImage fileUpload(MultipartFile file);
	
	//int updateEventIdforImage(Long eventId, Long picId);
	
	EventImage getPicture(Long picId);
	
	String getFileName(Long picId);
}
