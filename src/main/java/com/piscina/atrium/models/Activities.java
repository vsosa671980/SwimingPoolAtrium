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
	  @OneToMany(mappedBy = "activity")
	  private List<Planning>planning = new ArrayList<>();

	public Activities() {
	}

	public Activities(String name, List<Planning> planning) {
		this.name = name;
		this.planning = planning;
	}

	public List<Planning> getPlanning() {
		return planning;
	}

	public void setPlanning(List<Planning> planning) {
		this.planning = planning;
	}

	public Activities(String name) {
		this.name = name;

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
}
