package com.fundThru.app.eventList.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue
	@Column(name = "event_id")
	private Long eventId;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "event_description")
	private String eventDescription;
	
	@Column(name = "event_start")
	private Date eventStart;
	
	@Column(name = "event_end")
	private Date eventEnd;
	
//	@Column(name = "pic_id")
//	private String picId;
	
	@OneToOne
	@JoinColumn(name = "pic_id")
	EventImage eventImage;
	
//	@Column(name = "event_pic", nullable=false, columnDefinition="mediumblob")
//	private byte[] eventPic;

//	public String getPicId() {
//		return picId;
//	}
//
//	public void setPicId(String picId) {
//		this.picId = picId;
//	}

	public Long getEventId() {
		return eventId;
	}

	public EventImage getEventImage() {
		return eventImage;
	}

	public void setEventImage(EventImage eventImage) {
		this.eventImage = eventImage;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Date getEventStart() {
		return eventStart;
	}

	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}

	public Date getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}

//	public byte[] getEventPic() {
//		return eventPic;
//	}
//
//	public void setEventPic(byte[] eventPic) {
//		this.eventPic = eventPic;
//	}
}
