package com.fundThru.app.eventList.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import com.fundThru.app.eventList.model.Event;
import com.fundThru.app.eventList.model.EventImage;
import com.fundThru.app.eventList.repository.EventImageRepository;
import com.fundThru.app.eventList.repository.EventRepository;
import com.fundThru.app.eventList.repository.UserRepository;
import com.fundThru.app.eventList.service.EventImageService;
import com.fundThru.app.eventList.service.EventService;
import org.springframework.util.StringUtils;



@Service
public class EventImageServiceImpl implements EventImageService{

	@Autowired
	EventImageRepository eventImageRepository;
	
	@Override
	public EventImage fileUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		
		//Document doc = new Document();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }

            EventImage dbFile = new EventImage(fileName, file.getContentType(), file.getBytes());

            return eventImageRepository.save(dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public EventImage getPicture(Long picId) {
		// TODO Auto-generated method stub
		return eventImageRepository.getPicture(picId);
	}

	@Override
	public String getFileName(Long picId) {
		// TODO Auto-generated method stub
		return eventImageRepository.getFilename(picId);
	}

//	@Override
//	public int updateEventIdforImage(Long eventId, Long picId) {
//		// TODO Auto-generated method stub
//		int success = eventImageRepository.updateEventIdforImage(eventId, picId);
//		return success;
//	}

	
	
}
