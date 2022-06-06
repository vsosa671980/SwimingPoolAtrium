package com.piscina.atrium.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.Join;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idRole;
	
	
   @Column(name ="nameRole")
   private String nameRole;
   
   @ManyToOne()
   @JoinColumn(name ="iduser")
   private Users iduser;
   
   


}
