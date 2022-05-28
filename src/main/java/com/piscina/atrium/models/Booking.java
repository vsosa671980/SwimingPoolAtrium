package com.piscina.atrium.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity(name = "bookings")
@Component
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbookings")
	private long idbookings;


	//Indicate the relation witch Users Class ManyToONe
	  @ManyToOne()
	  @JoinColumn(name = "idusers")
	  private Users idusers;
	  
	  
	  //Relation witch Booking and Planning ManyToMany
	  @ManyToOne()
	  @JoinColumn (name="bookings")
	  private Planning plannings;


	public Booking() {
	}

	public Booking(long idbookings, Users idusers, Planning plannings) {
		this.idbookings = idbookings;
		this.idusers = idusers;
		this.plannings = plannings;
	}

	public Booking(Users idusers, Planning plannings) {
		this.idusers = idusers;
		this.plannings = plannings;
	}

	public long getIdbookings() {
		return idbookings;
	}

	public void setIdbookings(long idbookings) {
		this.idbookings = idbookings;
	}

	public Users getIdusers() {
		return idusers;
	}

	public void setIdusers(Users idusers) {
		this.idusers = idusers;
	}

	public Planning getPlannings() {
		return plannings;
	}

	public void setPlannings(Planning plannings) {
		this.plannings = plannings;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"idbookings=" + idbookings +
				", idusers=" + idusers +
				", plannings=" + plannings +
				'}';
	}
}
