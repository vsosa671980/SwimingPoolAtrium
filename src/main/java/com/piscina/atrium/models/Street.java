package com.piscina.atrium.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="street")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Street {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_street")
	private long idStreet;
	
	@Column(name = "name_street")
	private String nameStreet;
	
	@Column(name = "occupation")
	private int occupation;

	public Street() {
		
	}

	public Street(Long idStreet, String nameStreet, int occupation) {
		super();
		this.idStreet = idStreet;
		this.nameStreet = nameStreet;
		this.occupation = occupation;
	}

	public Long getIdStreet() {
		return idStreet;
	}

	public void setIdStreet(Long idStreet) {
		this.idStreet = idStreet;
	}

	public String getNameStreet() {
		return nameStreet;
	}

	public void setNameStreet(String nameStreet) {
		this.nameStreet = nameStreet;
	}

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Street [idStreet=" + idStreet + ", nameStreet=" + nameStreet + ", occupation=" + occupation + "]";
	}
	
	
	
	
	

}
