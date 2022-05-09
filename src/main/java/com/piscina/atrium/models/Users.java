package com.piscina.atrium.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idusers;

	@NotBlank(message = "El nombre no puede estar vacio cenutrio")
	private String name;

	@NotBlank(message = "Tienes que indicar un apellido")
	private String surname;

	@NotBlank
	private String phone;
    

	@NotBlank
	private String DNI;

	private String birthdate;

	@Email
	@NotEmpty
	private String email;

	@NotBlank
	private String status;
   
	private String password;

	private String img;

	private int age;

	// Relation witch Book table
	@OneToMany(mappedBy = "idusers", cascade = CascadeType.ALL)
	private List<Booking> reservas = new ArrayList<>();

	// Constructor empty

	public Users() {
	}

	public Users(long idusers, @NotBlank(message = "El nombre no puede estar vacio cenutrio") String name,
			@NotBlank(message = "Tienes que indicar un apellido") String surname, @NotBlank String phone,
			String birthdate, @Email @NotEmpty String email, @NotBlank String status, String password, String img, String DNI	) {
		this.idusers = idusers;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.email = email;
		this.status = status;
		this.password = password;
		this.img = img;
		this.DNI = DNI;
	
	}

	public Users(long idusers, @NotBlank(message = "El nombre no puede estar vacio cenutrio") String name,
			@NotBlank(message = "Tienes que indicar un apellido") String surname, @NotBlank String phone,
			String birthdate, @Email @NotEmpty String email, @NotBlank String status, String password, String img,
			int age) {
		this.idusers = idusers;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.birthdate = birthdate;
		this.email = email;
		this.status = status;
		this.password = password;
		this.img = img;
		
		
	}


	// Getters and Setters

	@Override
	public String toString() {
		return "Users [idusers=" + idusers + ", name=" + name + ", surname=" + surname + ", phone=" + phone
				+ ", birthdate=" + birthdate + ", email=" + email + ", status=" + status + ", password=" + password
				+ ", img=" + img + ", reservas=" + reservas + "]";
	}

	public long getIdusers() {
		return idusers;
	}

	public void setIdusers(long idusers) {
		this.idusers = idusers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAge() {
		return age;
	}


	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	


	public void setAge() {

		// Obtein the actual Year
		int ageNow = LocalDate.now().getYear();

		// Create the birtday in Localdate Object
		LocalDate age = LocalDate.parse(this.birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		// Obtein the born year
		int edad = age.getYear();

		// Set the age of user

		this.age = ageNow - edad;
	}

	

}