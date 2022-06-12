package com.piscina.atrium.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Array;
import java.util.List;

import lombok.Data;

@Entity
@Table(name="street")
@Data
public class Street {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_street")
		private long idStreet;
		
		@Column(name="name_street")
		private String nameStreet;

		
		
		@ManyToMany(mappedBy = "idStreet")
		private List<Planning> planning = new ArrayList<>();
		
	

		public Street() {
			
		}

		public Street(long idStreet, String nameStreet) {
			
			this.idStreet = idStreet;
			this.nameStreet = nameStreet;
		
		}
		

		public Street(long idStreet, String nameStreet, List<Planning> planning) {
			super();
			this.idStreet = idStreet;
			this.nameStreet = nameStreet;
			this.planning = planning;
		}



	public long getIdStreet() {
			return idStreet;
		}

		public void setIdStreet(long idStreet) {
			this.idStreet = idStreet;
		}

		public String getNameStreet() {
			return nameStreet;
		}

		public void setNameStreet(String nameStreet) {
			this.nameStreet = nameStreet;
		}



	public List<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(List<Planning> planning) {
		this.planning = planning;
	}

	@Override
	public String toString() {
		return "Street [idStreet=" + idStreet + ", nameStreet=" + nameStreet + ", planning=" + planning + "]";
	}
	
	
}
