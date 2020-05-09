package com.gamepride.platform.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.gamepride.platform.entity.LanCenter;

@Named
public class LanCenterRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="TPGamepridePU")
	private EntityManager em;
	
	
	@Transactional
	public Integer insert(LanCenter lancenter) throws Exception {
		em.persist(lancenter);
		return lancenter.getId();
	}
	
	public List<LanCenter> list() throws Exception {
		List<LanCenter> lancenters = new ArrayList<>();

		Query query = em.createQuery("SELECT l FROM lancenter l");
		lancenters = (List<LanCenter>) query.getResultList();
		return lancenters;
	}
}