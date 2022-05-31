package com.piscina.atrium.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="planning")
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  ="id_planning")
	private Long idPlanning;
	
	

    private String planningDay;
    
	
	@Column(name = "init_time")
    private LocalTime initTime;
    
	@Column(name = "Finish_time")
    private LocalTime FinishTime;

	private int ocupacion;

	public Long getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(Long idPlanning) {
		this.idPlanning = idPlanning;
	}

	//Relation ManyToMany Planning Street
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Street> idStreet = new ArrayList<Street>();


	@ManyToOne
	@JoinColumn(name = "id_activity")
	private Activities activity;
	@OneToMany(mappedBy = "plannings")
	private List<Booking> bookings = new ArrayList<>();
	
	//Relation Planning witch Booking


	public Planning(Long idPlanning,  String planningDay, LocalTime initTime, LocalTime finishTime, List<Street> idStreet, List<Booking> booking) {
		this.idPlanning = idPlanning;

		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
		this.booking = booking;

	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "planning_Booking",
			joinColumns = @JoinColumn(name ="id_planning"),
		    inverseJoinColumns = @JoinColumn(name="id_booking")
				
			)
	private List<Booking> booking = new ArrayList<Booking>();
	

	//Relaation witch Activities Class	

	public Planning() {
		
	}

	public Planning(Long idPlanning,  String planningDay, LocalTime initTime,
			LocalTime finishTime) {
		
		this.idPlanning = idPlanning;

		this.planningDay = planningDay;
		this.initTime = initTime;
		this.FinishTime = finishTime;
	}


	public Activities getActivity() {
		return activity;
	}

	public void setActivity(Activities activity) {
		this.activity = activity;
	}

	public Planning(Long idPlanning, String planningDay, LocalTime initTime,
					LocalTime finishTime, List<Street> idStreet) {
		
		this.idPlanning = idPlanning;

		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
	}
	
	

	public Planning( String planningDay, LocalTime initTime, LocalTime finishTime,
			List<Street> idStreet, List<Booking> booking) {

		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
		this.booking = booking;

	}


	public Planning(Long idPlanning, String planningDay, LocalTime initTime, LocalTime finishTime, int ocupacion, List<Street> idStreet, Activities activity, List<Booking> bookings, List<Booking> booking) {
		this.idPlanning = idPlanning;
		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.ocupacion = ocupacion;
		this.idStreet = idStreet;
		this.activity = activity;
		this.bookings = bookings;
		this.booking = booking;
	}

	public Planning(Long idPlanning, String planningDay, LocalTime initTime, LocalTime finishTime,
					int ocupacion, List<Street> idStreet, List<Booking> booking) {
		this.idPlanning = idPlanning;

		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.ocupacion = ocupacion;
		this.idStreet = idStreet;
		this.booking = booking;

	}


	public String getPlanningDay() {
		return planningDay;
	}

	public void setPlanningDay(String planningDay) {
		this.planningDay = planningDay;
	}

	public LocalTime getInitTime() {
		return initTime;
	}

	public void setInitTime(LocalTime initTime) {
		this.initTime = initTime;
	}

	public LocalTime getFinishTime() {
		return FinishTime;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setFinishTime(LocalTime finishTime) {
		FinishTime = finishTime;
	}

	public List<Street> getIdStreet() {
		return idStreet;
	}

	public void setIdStreet(List<Street> idStreet) {
		this.idStreet = idStreet;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}



	public int getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public DayOfWeek getDayOfWeek(String date){

		LocalDate day = LocalDate.parse(date);


		return day.getDayOfWeek();
	}

}
