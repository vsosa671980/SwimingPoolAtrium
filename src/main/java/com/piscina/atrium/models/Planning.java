package com.piscina.atrium.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;
import java.util.List;

@Entity
@Table(name="planning")
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  ="id_planning")
	private Long idPlanning;
	
	
	@Column(name="name_planing")
	private String namePlanning;
	
    private String planningDay;
    
	
	@Column(name = "init_time")
    private LocalTime initTime;
    
	@Column(name = "Finish_time")
    private LocalTime FinishTime;
	
	
	
	//Relation ManyToMany Planning Street
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "planning_Street",
			joinColumns = @JoinColumn(name ="id_planning"),
		    inverseJoinColumns = @JoinColumn(name="id_street")
				
			)
	private List<Street> idStreet = new ArrayList<Street>();
	
	//Relation Planning witch Booking


	public Planning(Long idPlanning, String namePlanning, String planningDay, LocalTime initTime, LocalTime finishTime, List<Street> idStreet, List<Booking> booking, List<Activities> activities) {
		this.idPlanning = idPlanning;
		this.namePlanning = namePlanning;
		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
		this.booking = booking;
		this.activities = activities;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "planning_Booking",
			joinColumns = @JoinColumn(name ="id_planning"),
		    inverseJoinColumns = @JoinColumn(name="id_booking")
				
			)
	private List<Booking> booking = new ArrayList<Booking>();
	

	//Relaation witch Activities Class	
	@OneToMany(mappedBy = "planning")
	private List<Activities> activities;
	
   
	public Planning() {
		
	}

	public Planning(Long idPlanning, String namePlanning, String planningDay, LocalTime initTime,
			LocalTime finishTime) {
		
		this.idPlanning = idPlanning;
		this.namePlanning = namePlanning;
		this.planningDay = planningDay;
		this.initTime = initTime;
		this.FinishTime = finishTime;
	}
	
  

	public Planning(Long idPlanning, String namePlanning, String planningDay, LocalTime initTime,
			LocalTime finishTime, List<Street> idStreet) {
		
		this.idPlanning = idPlanning;
		this.namePlanning = namePlanning;
		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
	}
	
	

	public Planning(String namePlanning, String planningDay, LocalTime initTime, LocalTime finishTime,
			List<Street> idStreet, List<Booking> booking, List<Activities> activities) {
		this.namePlanning = namePlanning;
		this.planningDay = planningDay;
		this.initTime = initTime;
		FinishTime = finishTime;
		this.idStreet = idStreet;
		this.booking = booking;
		this.activities = activities;
	}

	public List<Street> getIdStreet() {
		return idStreet;
	}

	public void setIdStreet(List<Street> idStreet) {
		this.idStreet = idStreet;
	}

	public Long getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(Long idPlanning) {
		this.idPlanning = idPlanning;
	}

	public String getNamePlanning() {
		return namePlanning;
	}

	public void setNamePlanning(String namePlanning) {
		this.namePlanning = namePlanning;
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

	public void setFinishTime(LocalTime finishTime) {
		FinishTime = finishTime;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", namePlanning=" + namePlanning + ", planningDay=" + planningDay
				+ ", initTime=" + initTime + ", FinishTime=" + FinishTime + ", idStreet=" + idStreet + ", booking="
				+ booking + ", activities=" + activities + "]";
	}
	
	


	
	
	
	


	
	
	




	
	
	
	

    

	

}
