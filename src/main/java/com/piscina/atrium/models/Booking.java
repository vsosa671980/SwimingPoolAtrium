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
	
    @Column(name="type_booking")
    private String name;  

	@Column(name="day_booking")
	private String dayBook;

	@Column(name = "hour_booking")
	private String hourBook;

	@Column(name="booking_status")
	private String bookingStatus;

	  public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	//Indicate the relation witch Users Class ManyToONe
	  @ManyToOne()
	  @JoinColumn(name = "idusers")
	  private Users idusers;
	  
	  
	  //Relation witch Booking and Planning ManyToMany
	  @ManyToMany(mappedBy = "booking",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	  private List<Planning> plannings;


	public Booking() {
	}

	public Booking( String name, String dayBook, String hourBook, Users idusers) {
	
		this.name = name;
		this.dayBook = dayBook;
		this.hourBook = hourBook;
		this.idusers = idusers;
	}


	public Booking(long idbookings, String name, String dayBook, String hourBook, Users idusers) {
		this.idbookings = idbookings;
		this.name = name;
		this.dayBook = dayBook;
		this.hourBook = hourBook;
		this.idusers = idusers;
	}
	
	




	public Booking(String name, String dayBook, String hourBook, String bookingStatus, Users idusers,
			List<Planning> plannings) {
		this.name = name;
		this.dayBook = dayBook;
		this.hourBook = hourBook;
		this.bookingStatus = bookingStatus;
		this.idusers = idusers;
		this.plannings = plannings;
	}

	public long getIdbookings() {
		return idbookings;
	}

	public void setIdbookings(long idbookings) {
		this.idbookings = idbookings;
	}

	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}

	@Override
	public String toString() {
		return "Booking [idbookings=" + idbookings + ", name=" + name + ", dayBook=" + dayBook + ", hourBook="
				+ hourBook + ", bookingStatus=" + bookingStatus + ", idusers=" + idusers + ", plannings=" + plannings
				+ "]";
	}
	
	

















	


	

}
