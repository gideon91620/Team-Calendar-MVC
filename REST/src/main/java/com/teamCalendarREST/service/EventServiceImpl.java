package com.teamCalendarREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import com.teamCalendarREST.dto.EventDto;
import com.teamCalendarREST.model.Event;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {
	
	   @Autowired RestTemplate restTemplate;
	   private final String baseUrl = "http://localhost:8085/events/";
		
	   
	   //private EventDao eventDao;
	   
	   @Override
	    public ResponseEntity<Event[]> getAllEvents() {
	        return restTemplate.getForEntity(baseUrl, Event[].class);
	    }

	   @Override
	    public ResponseEntity<?> addEvent(EventDto dto) {
		   return restTemplate.postForObject(baseUrl, dto, ResponseEntity.class);
	    }

	   @Override
	    public ResponseEntity<Event[]> getEvent(Long id) {
		   return restTemplate.getForEntity(baseUrl + id, Event[].class);
	    }

	   @Override
	    public ResponseEntity<?> updateEvent(Long id, EventDto dto) {
		   restTemplate.put(baseUrl + id, dto, ResponseEntity.class);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	    }

	   @Override
	    public ResponseEntity<?> deleteEvent(Long id) {
		   restTemplate.delete(baseUrl + id, ResponseEntity.class);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	    }

}
