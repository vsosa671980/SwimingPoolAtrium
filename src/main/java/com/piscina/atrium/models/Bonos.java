package com.piscina.atrium.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Bonos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBonos;

	@Column(name = "bono_name")
	private String bonoName;


	@Column(name = "duration")
	private int duration;

	@Column(name = "img")
	private String img;

	private double costBonos;

	@ManyToOne()
	@JoinColumn(name = "idusers")
	private Users user;

	//Relation witch Payment Class
	@OneToMany(mappedBy = "bonos")
	private List<Payments> payments;

	public Bonos() {
	}

	public Bonos(String bonoName, int duration, String img, double costBonos, Users user, List<Payments> payments) {
		this.bonoName = bonoName;
		this.duration = duration;
		this.img = img;
		this.costBonos = costBonos;
		this.user = user;
		this.payments = payments;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getCostBonos() {
		return costBonos;
	}

	public void setCostBonos(double costBonos) {
		this.costBonos = costBonos;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}


}





	
	
	


