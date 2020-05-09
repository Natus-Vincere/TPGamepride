package com.gamepride.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.gamepride.platform.entity.Gamer;

@Named
public class GamerRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="TPGamepridePU")
	private EntityManager em;
	
	
	@Transactional
	public Integer insert(Gamer gamer) throws Exception {
		em.persist(gamer);
		return gamer.getId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Gamer> list() throws Exception {
		List<Gamer> gamers = new ArrayList<>();

		Query query = em.createQuery("SELECT l FROM gamer l");
		gamers = (List<Gamer>) query.getResultList();
		return gamers;
	}
}