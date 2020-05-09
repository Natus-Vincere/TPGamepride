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
import com.gamepride.platform.entity.Role;

@Named
public class RoleRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="TPGamepridePU")
	private EntityManager em;
	
	
	@Transactional
	public Integer insert(Role role) throws Exception {
		em.persist(role);
		return role.getId();
	}
	
	public List<Role> list() throws Exception {
		List<Role> roles = new ArrayList<>();

		Query query = em.createQuery("SELECT l FROM role l");
		roles = (List<Role>) query.getResultList();
		return roles;
	}
}