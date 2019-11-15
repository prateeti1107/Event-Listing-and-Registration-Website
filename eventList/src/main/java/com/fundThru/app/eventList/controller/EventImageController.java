package com.fundThru.app.eventList.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fundThru.app.eventList.model.Event;
import com.fundThru.app.eventList.model.EventImage;
import com.fundThru.app.eventList.service.EventImageService;
import com.fundThru.app.eventList.service.EventService;

@RestController
@RequestMapping("/eventImage")
@CrossOrigin
public class EventImageController {

	private static final Logger logger = LoggerFactory.getLogger(EventImageController.class);
	
	@Autowired
	EventImageService eventImageService;
	
	@Autowired
	EventService eventService;
	
	@PostMapping("/uploadFile")
    public Long uploadFile(@RequestParam("file") MultipartFile file) {
		//Event event = eventService.searchEventById(eventId);
		EventImage dbFile = eventImageService.fileUpload(file);
       // System.out.println("HELOOOO" + dbFile.getEvent().getEventId());
        
        
        Long fileId = dbFile.getPicId();
        //dbFile.setEvent(event);
        //int success = eventImageService.updateEventIdforImage(eventId,fileId);
       // System.out.println("success= " + success);
        return fileId;
    }
	
//	@PostMapping("/uploadFile")
//    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		
//		EventImage dbFile = eventImageService.fileUpload(file);
//       // System.out.println("HELOOOO" + dbFile.getEvent().getEventId());
//        
//        
//        Long fileId = dbFile.getPicId();
//        
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//        		.path("/eventImage/download/")
//    			.path(fileName)
//    			.toUriString();
//        return ResponseEntity.ok(fileDownloadUri);
//       
//    }
	
	@RequestMapping(value = "/download/{filename}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity downloadFile(@PathVariable String filename) throws IOException {
        
		
		//String filename = eventImageService.getFileName(picId);
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length()) 
                .body(resource);
    }
	
}
