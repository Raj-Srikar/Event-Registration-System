package com.cognizant.ers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.ers.entity.users.Participant;

@Controller
public class EventController {
	
	@GetMapping("/showParticipants")
	public ModelAndView showParticipantList(@RequestParam("title") String eventTitle) {
		ModelAndView participantListModelView = new ModelAndView();
		participantListModelView.setViewName("showParticipants");
		
		participantListModelView.addObject("eventTitle", eventTitle);
		
		List<Participant> participants = new ArrayList<>();
		// TODO: Fetch the participant list
		//		 SELECT er.participant_username FROM event_registration er INNER JOIN events e
		// 		 ON er.event_title = e.title WHERE e.title = "_____";
		
		participantListModelView.addObject("participantsList", participants);
		return participantListModelView;
	}
	
}
