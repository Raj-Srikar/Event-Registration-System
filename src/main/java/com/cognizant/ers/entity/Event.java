package com.cognizant.ers.entity;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {
	
	@Id
	private String title;
	private LocalDate date;
	private LocalTime time;
	private String location;
	private int availableslots;
	private String description;
	private Blob image;
	private String organizerUsername;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getAvailableslots() {
		return availableslots;
	}
	public void setAvailableslots(int availableslots) {
		this.availableslots = availableslots;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}

	public String getOrganizerUsername() {
		return organizerUsername;
	}
	public void setOrganizerUsername(String organizerUsername) {
		this.organizerUsername = organizerUsername;
	}
	
	public Event(String title, LocalDate date, LocalTime time, String location, int availableslots, String description,
			Blob image, String organizerUsername) {
		super();
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.availableslots = availableslots;
		this.description = description;
		this.image = image;
		this.organizerUsername = organizerUsername;
	}
	public Event() {
	}
	
	
	// Fetched all the participants registered in the Event
	public void fetchParticipants() {
		
	}
	
}
