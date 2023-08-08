package com.cognizant.ers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.ers.entity.Event;

public interface EventRepository extends CrudRepository<Event, String>{
	@Query(
			value="SELECT er.participant_username FROM event_registration er INNER JOIN event e ON er.event_title = e.title WHERE e.title = ?1",
			nativeQuery=true)
	List<String> registeredParticipants(String eventTitle);
}
