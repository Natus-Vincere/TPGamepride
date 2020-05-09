package com.gamepride.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.gamepride.platform.entity.Event;


@Named
public class EventRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="TPGamepridePU")
	private EntityManager em;
	
	
	@Transactional
	public Integer insert(Event event) throws Exception {
		em.persist(event);
		return event.getId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> list() throws Exception {
		List<Event> events = new ArrayList<>();

		Query query = em.createQuery("SELECT l FROM event l");
		events = (List<Event>) query.getResultList();
		return events;
	}
}
