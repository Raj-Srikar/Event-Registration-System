package com.cognizant.ers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.ers.entity.users.Participant;
import com.cognizant.ers.repo.EventRepository;

@Controller
public class EventController {
	
	@Autowired
	ApplicationContext context;
	
	@GetMapping("/showParticipants")
	public ModelAndView showParticipantList(@RequestParam("title") String eventTitle) {
		ModelAndView participantListModelView = new ModelAndView();
		participantListModelView.setViewName("participant-list");
		
		participantListModelView.addObject("eventTitle", eventTitle);
		
		// TODO: Fetch the participant list
		//		 SELECT er.participant_username FROM event_registration er INNER JOIN events e
		// 		 ON er.event_title = e.title WHERE e.title = "_____";
		EventRepository repo = context.getBean(EventRepository.class);
		List<String> participants = repo.registeredParticipants(eventTitle);

		participantListModelView.addObject("participantsList", participants);
		return participantListModelView;
	}
	
}
