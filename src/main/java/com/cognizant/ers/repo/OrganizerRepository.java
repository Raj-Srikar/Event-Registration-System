package com.cognizant.ers.repo;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.ers.entity.users.Organizer;

import jakarta.transaction.Transactional;

public interface OrganizerRepository extends CrudRepository<Organizer, String> {
	
	@Modifying
    @Query(value = "UPDATE event SET title=?2, date=?3, time=?4, location=?5, availableSlots=?6, description=?7, image=?8, organizer_username=?9 WHERE title=?1", nativeQuery = true)
    @Transactional
    void editEvent(String eventTitle, String title, String date, String time, String location, int availableSlots,
			String description, InputStream image, String organizerUsername);
	
	
	
	@Query(
		value="SELECT e.title FROM event e INNER JOIN organizer o ON e.organizer_username = o.username WHERE o.username = ?1",
		nativeQuery=true)
	List<String> myEvents(String organizer);
}
