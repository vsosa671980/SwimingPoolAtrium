package com.piscina.atrium.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
    @Column(name="type_booking")
    private String typeBooking;  

	@Column(name="day_booking")
	private String dayBook;
    

	@Column(name = "hour_booking")
	private String hourBook;
	
	
	@Column(name="booking_status")
	private String bookingStatus;
	
	

	  //Indicate the relation witch Users Class ManyToONe
	  @ManyToOne
	  @JoinColumn(name = "idusers")
	  private Users idusers;
    

	  //Relationship  with Streets
	 
	  @ManyToOne
	  @JoinColumn(name =  "idStreet")
	  private Street idStreet;


	public Booking() {
	}

	public Booking( String typeBooking, String dayBook, String hourBook, Users idusers) {
	
		this.typeBooking = typeBooking;
		this.dayBook = dayBook;
		this.hourBook = hourBook;
		this.idusers = idusers;
	}


	public Booking(long idbookings, String typeBooking, String dayBook, String hourBook, Users idusers) {
		this.idbookings = idbookings;
		this.typeBooking = typeBooking;
		this.dayBook = dayBook;
		this.hourBook = hourBook;
		this.idusers = idusers;
	}




	public long getIdbookings() {
		return idbookings;
	}

	public void setIdbookings(long idbookings) {
		this.idbookings = idbookings;
	}

	
	public String getTypeBooking() {
		return typeBooking;
	}

	public void setTypeBooking(String typeBooking) {
		this.typeBooking = typeBooking;
	}

	public String getDayBook() {
		return this.dayBook;
	}

	public void setDayBook(String dayBook) {
		this.dayBook = dayBook;
	}

	public String getHourBook() {
		return this.hourBook;
	}

	public void setHourBook(String hourBook) {
		this.hourBook = hourBook;
	}

	public Users getIdusers() {
		return idusers;
	}

	public void setIdusers(Users idusers) {
		this.idusers = idusers;
	}

















	


	

}
