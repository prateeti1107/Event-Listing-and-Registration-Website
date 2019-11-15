package com.fundThru.app.eventList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_event")
public class UserEvent {
	
	@Id
	@GeneratedValue
	@Column(name = "userEvent_id")
	private Long userEventId;

	public Long getUserEventId() {
		return userEventId;
	}

	public void setUserEventId(Long userEventId) {
		this.userEventId = userEventId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	User user; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "event_id")
	Event event;
}
