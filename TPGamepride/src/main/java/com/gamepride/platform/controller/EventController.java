package com.gamepride.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.gamepride.platform.entity.Event;
import com.gamepride.platform.repository.EventRepository;



@Named
@ViewScoped
public class EventController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EventRepository eventRepository;
	
	private Event event;
	
	private Event eventSelect;
	private List<Event> events;
	
	@PostConstruct
	public void init() {
		event = new Event();

		this.loadEvents();
	}

	public void loadEvents() {
		try {
			this.events = eventRepository.list();
		} catch (Exception e) {
		}

	}

	public void saveEvent() {
		try {
			eventRepository.insert(event);
			
			loadEvents();
			clearForm();
		} catch (Exception e) {
		}
	}
	
	public void selectEvent(SelectEvent e) {
		this.eventSelect=(Event) e.getObject();
	}
	
	
	public void clearForm() {
		this.event = new Event();
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Event getEditorial() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEventSelect() {
		return eventSelect;
	}

	public void setEventSelect(Event eventSelect) {
		this.eventSelect = eventSelect;
	}

	public List<Event> getEvent() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
