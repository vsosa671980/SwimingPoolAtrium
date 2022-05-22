package com.piscina.atrium.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Bonos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBonos;
	
	@Column(name="bono_name")
	private String bonoName;
	
	@Column(name="date_init")
	private LocalDate dateInit;
	
	
	@Column(name="date_finish")
	private LocalDate dateFinish;
	
	@Column(name = "state")
	private String state;
	
	
	@ManyToOne()
	@JoinColumn(name  ="idusers")
	private Users user;


	public Bonos() {
	}


	public Bonos(String bonoName, LocalDate dateInit, LocalDate dateFinish, String state, Users user) {
		this.bonoName = bonoName;
		this.dateInit = dateInit;
		this.dateFinish = dateFinish;
		this.state = state;
		this.user = user;
	}


	public String getState() {
		return state;
	}


	public void setState() {
		
		if(this.dateFinish.isAfter(LocalDate.now())) {
			
			this.state = "disponible";
			
		}else {
			this.state = "caducado";
		}
			
	}


	public Bonos(String bonoName, LocalDate dateInit, LocalDate dateFinish, Users user) {
		this.bonoName = bonoName;
		this.dateInit = dateInit;
		this.dateFinish = dateFinish;
		this.user = user;
	}


	public Long getIdBonos() {
		return idBonos;
	}


	public void setIdBonos(Long idBonos) {
		this.idBonos = idBonos;
	}


	public String getBonoName() {
		return bonoName;
	}


	public void setBonoName(String bonoName) {
		this.bonoName = bonoName;
	}


	public LocalDate getDateInit() {
		return dateInit;
	}


	public void setDateInit(LocalDate dateInit) {
		this.dateInit = dateInit;
	}


	public LocalDate getDateFinish() {
		return dateFinish;
	}


	public void setDateFinish(LocalDate dateFinish) {
		this.dateFinish = dateFinish;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}
	


	
	
	

}
