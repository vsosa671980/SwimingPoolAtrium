package com.piscina.atrium.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idRole;
	
	
   @Column(name ="nameRole")
   private String nameRole;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name ="idusers")
	private List<Users> user = new ArrayList<>();

	public Roles() {
	}

	public Roles(String nameRole, List<Users> user) {
		this.nameRole = nameRole;
		this.user = user;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}
}
