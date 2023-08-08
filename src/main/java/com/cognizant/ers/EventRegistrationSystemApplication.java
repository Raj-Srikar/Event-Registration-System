package com.cognizant.ers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ers.entity.Event;
import com.cognizant.ers.repo.EventRepository;

@SpringBootApplication
public class EventRegistrationSystemApplication {

	@Autowired
	static ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(EventRegistrationSystemApplication.class, args);

//		EventRepository repo = context.getBean(EventRepository.class);
//		Event e = new Event("My Event", null, null, null, 0, null, null, "org");
//		repo.save(e);
	}

}
