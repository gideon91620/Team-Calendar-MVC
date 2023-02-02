package com.teamCalendarREST.service;

import org.springframework.http.ResponseEntity;

import com.teamCalendarREST.dto.EventDto;
import com.teamCalendarREST.model.Event;

public interface EventService {
	
	public ResponseEntity<Event[]> getAllEvents();
	public ResponseEntity<?> addEvent(EventDto dto);
	public ResponseEntity<Event[]> getEvent(Long id);
	public ResponseEntity<?> updateEvent(Long id, EventDto dto);
	public ResponseEntity<?> deleteEvent(Long id);


}
