package com.gamepride.platform.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "gamer")
public class Gamer implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name",nullable=false,length=65)
	private String name;
	
	@Column(name="username",nullable=false,length=65)
	private String username;
	
	@Column(name="phone",nullable=false,length=9)
	private int phone;
	
	@Column(name="account_number",nullable=false,length=30)
	private int accountNumber;
	
	@Column(name="email",nullable=false,length=50)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="lastname",nullable=false,length=50)
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="event",nullable=false)
	private Event event;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
