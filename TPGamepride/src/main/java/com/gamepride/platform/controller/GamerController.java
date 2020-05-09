package com.gamepride.platform.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.gamepride.platform.entity.Event;
import com.gamepride.platform.entity.Gamer;
import com.gamepride.platform.repository.EventRepository;
import com.gamepride.platform.repository.GamerRepository;



@Named
@ViewScoped
public class GamerController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GamerRepository gamerRepository;
	
	@Inject
	private EventRepository eventRepository;

	private Gamer gamer;
	private Gamer gamerSelect;
	private List<Gamer> gamers;
	
	private Event event;
	private List<Event> events;
	
	
	@PostConstruct
	public void init() {
		
		gamer = new Gamer();
		gamerSelect=new Gamer();
		
		this.loadGamers();
		this.loadEvents();	
	}
	
	public void loadGamers() {
		try {
			this.gamers=gamerRepository.list();
		}catch (Exception e) {
			
		}
	}
	
	public void loadEvents(){
		try {
			this.events=eventRepository.list();
		}catch (Exception e) {
			
		}
	}
	
	public void saveGamer() {
		try {
			gamer.setEvent(event);
			gamerRepository.insert(gamer);
			
			loadGamers();
			cleanForm();
		}catch (Exception e) {
			
		}
	}
	
	public void selectGamer(SelectEvent e) {
		this.gamerSelect=(Gamer)e.getObject();
	}
	public void cleanForm() {
		this.gamer=new Gamer();
		this.gamerSelect= null;
	}

	public GamerRepository getGamerRepository() {
		return gamerRepository;
	}

	public void setGamerRepository(GamerRepository gamerRepository) {
		this.gamerRepository = gamerRepository;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Gamer getGamerSelect() {
		return gamerSelect;
	}

	public void setGamerSelect(Gamer gamerSelect) {
		this.gamerSelect = gamerSelect;
	}

	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}