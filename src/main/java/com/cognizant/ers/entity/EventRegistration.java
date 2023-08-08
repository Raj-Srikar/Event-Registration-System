package com.cognizant.ers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EventRegistration {
	
	@Id
	private int registrationId;
	private String eventTitle;
	private String participantUsername;
	
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getParticipantUsername() {
		return participantUsername;
	}
	public void setParticipantUsername(String participantUsername) {
		this.participantUsername = participantUsername;
	}
	
	public EventRegistration() {
	}
	public EventRegistration(int registrationId, String eventTitle, String participantUsername) {
		this.registrationId = registrationId;
		this.eventTitle = eventTitle;
		this.participantUsername = participantUsername;
	}
	
}
