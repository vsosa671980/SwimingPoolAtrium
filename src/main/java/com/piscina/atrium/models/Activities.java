package com.piscina.atrium.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "activities")
public class Activities {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_activity")
	private Long idActivity;


	@Column(name = "activity_name")
	private String name;
	
	 //Relation witch Planning class
	  @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	  @JoinColumn(name = "id_planning")
	  private Planning plannig;

	public Activities() {
	}

	public Activities(String name, Planning plannig) {
		this.name = name;
		this.plannig = plannig;
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Planning getPlannig() {
		return plannig;
	}

	public void setPlannig(Planning plannig) {
		this.plannig = plannig;
	}

	@Override
	public String toString() {
		return "Activities [idActivity=" + idActivity + ", name=" + name + ", plannig=" + plannig + "]";
	}

   
	

	
}
