package com.cognizant.ers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cognizant.ers.entity.Event;
import com.cognizant.ers.entity.EventRegistration;
import com.cognizant.ers.entity.users.Organizer;
import com.cognizant.ers.entity.users.Participant;
import com.cognizant.ers.repo.EventRegistrationRepository;
import com.cognizant.ers.repo.EventRepository;
import com.cognizant.ers.repo.OrganizerRepository;
import com.cognizant.ers.repo.ParticipantRepository;

@SpringBootTest
class EventRegistrationSystemApplicationTests {

	@Autowired
	ApplicationContext context;
	
//	@Test
	void testAddEvent() {
		EventRepository repo = context.getBean(EventRepository.class);
		Event e = new Event("My Event", null, null, "", 0, "", null, "Org");
//		Event e = new Event();
//		e.setTitle("My Eventt");
//		e.setOrganizerUsername("Orgggg");
		
		repo.save(e);
	}

	@Test
	void viewParticipants() {
		EventRepository repo = context.getBean(EventRepository.class);
		System.out.println(repo.registeredParticipants("My Event3"));
	}
	
//	@Test
	void testAddOrg(){
		OrganizerRepository repo = context.getBean(OrganizerRepository.class);
		Organizer org = null;
		org = new Organizer("Org", "org@email.com", "12345678", "", "", 18);
		repo.save(org);
	}
	
//	@Test
	void testAddParticipant(){
		ParticipantRepository repo = context.getBean(ParticipantRepository.class);
		Participant org = new Participant("Part1", "part@email.com", "12345678", "", "", 21);
		repo.save(org);
	}
	
//	@Test
	void addEvents() {
		EventRepository repo = context.getBean(EventRepository.class);
		Event e = null;
		for (int i = 1; i < 6; i++) {
			e = new Event("My Event"+i, null, null, "", 0, "", null, "Org");
			repo.save(e);
		}
		for (int i = 6; i < 11; i++) {
			e = new Event("My Event"+i, null, null, "", 0, "", null, "Org1");
			repo.save(e);
		}
		
	}
	
//	@Test
	void myEvents() {
		OrganizerRepository repo = context.getBean(OrganizerRepository.class);
		System.out.println(repo.myEvents("Org"));
	}
	
//	@Test
	void editEventTest() {
		OrganizerRepository repo = context.getBean(OrganizerRepository.class);
		repo.editEvent("Kikiiiii", "My Event3", null, null, null, 0, "qwertyui", null, "Org2");
	}
	
//	@Test
	void addRegistration() {
		EventRegistrationRepository repo = context.getBean(EventRegistrationRepository.class);
		EventRegistration reg = new EventRegistration(0, "My Event4", "part2");
		repo.save(reg);
	}
	
//	@Test
	void registeredEvents() {
		EventRegistrationRepository repo = context.getBean(EventRegistrationRepository.class);
		System.out.println(repo.registeredEvents("part2"));
	}
	
}
