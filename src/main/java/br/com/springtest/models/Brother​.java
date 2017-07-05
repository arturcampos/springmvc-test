package br.com.springtest.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

public class Brother​ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brother_id")
	private int id;

	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "email")
	private String email;
	@OneToOne
	@Column(name = "user​_id")
	private User user​;
	@Column(name = "registration_date")
	@DateTimeFormat
	private Calendar registrationDate;
	@Column(name = "last_update")
	@DateTimeFormat
	private Calendar lastUpdate;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser​() {
		return user​;
	}
	public void setUser​(User user​) {
		this.user​ = user​;
	}
	public Calendar getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Calendar getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Brother​ [id=" + id + ", name=" + name + ", email=" + email + ", registrationDate=" + registrationDate
				+ ", lastUpdate=" + lastUpdate + "]";
	}
}

