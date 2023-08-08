package com.cognizant.ers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.ers.entity.EventRegistration;

public interface EventRegistrationRepository extends CrudRepository<EventRegistration, Integer> {
	@Query(
			value="SELECT er.event_title FROM event_registration er INNER JOIN participant p WHERE er.participant_username = ?1",
			nativeQuery=true)
	List<String> registeredEvents(String participantUsername);
}
