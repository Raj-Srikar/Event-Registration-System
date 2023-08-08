package com.cognizant.ers.entity.users;

import com.cognizant.ers.authentication.Authentication;

import jakarta.persistence.Entity;

@Entity
public class Participant extends Authentication {
	
	public Participant() {
		super();
		Authentication.tableName = "participant";
	}
	public Participant(String username, String email, String password, String firstname, String lastname, int age) {
		super(username, email, password, firstname, lastname, age);
		Authentication.tableName = "participant";
	}
	
	

	
	// Registers the user into the event
	public void registerEvent(String eventTitle) {
		// TODO: INSERT INTO event_registrations VALUES ("____","____");
	}
	
	// Fetches all the events the current user is registered into
	public void fetchRegisteredEvents() {
		// TODO: SELECT er.event_title FROM event_registration er INNER JOIN participants p;
	}
}
