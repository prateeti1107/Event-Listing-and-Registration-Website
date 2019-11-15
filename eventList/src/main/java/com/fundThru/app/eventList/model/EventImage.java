package com.fundThru.app.eventList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event_image")
public class EventImage {

	@Id
	@GeneratedValue
	@Column(name = "pic_id")
	Long picId;
	
	@Column(name = "filename")
	private String fileName;

	@Column(name = "filetype")
    private String fileType;
	
	@Lob
    private byte[] data;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "event_id")
//	Event event;
	
	
//	public Event getEvent() {
//		return event;
//	}
//
//	public void setEvent(Event event) {
//		this.event = event;
//	}

	public EventImage() {

    }

    public EventImage(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        
    }

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
    
}
