package com.cognizant.ers.entity.users;

import java.io.InputStream;

import com.cognizant.ers.authentication.Authentication;

import jakarta.persistence.Entity;

@Entity
public class Organizer extends Authentication {
	
	public Organizer() {
		super();
		Authentication.tableName = "organizer";
	}
	
	public Organizer(String username, String email, String password, String firstname, String lastname, int age) {
		super(username, email, password, firstname, lastname, age);
		Authentication.tableName = "organizer";
	}

	// Creates an event
	public void createEvent(String title, String date, String time, String location, int availableSlots,
			String description, InputStream image) {
		
	}
	
	// Edits an event
	public void editEvent(String title, String date, String time, String location, int availableSlots,
			String description, InputStream image) {
		
	}
	
	// Fetches all the events hosted by the current organizer
	public void fetchMyEvents() {
		// TODO: SELECT e.title FROM event e INNER JOIN organizers o
		// 		 ON e.organizer_username = o.username WHERE o.username = "_____";

	}
	
}
