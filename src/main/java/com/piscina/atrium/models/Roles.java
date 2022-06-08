package com.piscina.atrium.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Roles {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idRole;
	
	
   @Column(name ="nameRole")
   private String nameRole;

	@ManyToOne()
	@JoinColumn(name ="iduser")
	private Users user;

	public Roles() {
	}

	public Roles(String nameRole) {
		this.nameRole = nameRole;
	}

	public Roles(String nameRole, Users user) {
		this.nameRole = nameRole;
		this.user = user;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	

   
    
    
}
