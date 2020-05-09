package com.gamepride.platform.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="gamer_event")
public class EventGamer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="inscriptionAt",nullable=false,length=50)
	private String inscriptionAt;

	@ManyToOne
	@JoinColumn(name="id_gamer",nullable=false)
	private Gamer gamer;
	
	@ManyToOne
	@JoinColumn(name="id_event",nullable=false)
	private Event event;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInscriptionAt() {
		return inscriptionAt;
	}

	public void setInscriptionAt(String inscriptionAt) {
		this.inscriptionAt = inscriptionAt;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}