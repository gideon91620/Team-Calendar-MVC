package com.teamCalendarREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamCalendarREST.dto.EventDto;
import com.teamCalendarREST.model.Event;
import com.teamCalendarREST.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping
	public ResponseEntity<Event[]> events(){
		return eventService.getAllEvents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Event[]> getEventById(@PathVariable("id") Long id) {
		System.out.println("event id====================="+ id);
		return eventService.getEvent(id);
	}
	
	@PostMapping
	public ResponseEntity<?> events(@RequestBody EventDto event) {
		return eventService.addEvent(event);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto dto){
		eventService.updateEvent(id, dto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long id){
		eventService.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
