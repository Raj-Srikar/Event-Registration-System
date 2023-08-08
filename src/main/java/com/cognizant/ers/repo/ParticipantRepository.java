package com.cognizant.ers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.ers.entity.users.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, String> {
	@Query(
		value="SELECT er.event_title FROM event_registration er INNER JOIN participants p;",
		nativeQuery=true)
	List<Participant> registeredEvents();
}
