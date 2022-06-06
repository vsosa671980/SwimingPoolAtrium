
package com.piscina.atrium.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Entity
@Data
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idusers;

	@NotBlank(message ="Debes de indicar un nombre")
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


	private String status;
   
	private String password;

	private String img;

	private int age;

	// Relation witch Booking table OneToMany
	@OneToMany(mappedBy = "idusers")
	private List<Booking> bookings = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "idu")
	private List<Payments> payment = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Bonos> bonos = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Subscription> subscription = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "iduser")
    private List<Roles> rols = new ArrayList<>();

	public Users(String name, String surname, String phone, String DNI, String birthdate, String email, String status, String password, String img, int age, List<Booking> bookings, List<Payments> payment, List<Bonos> bonos, ArrayList<Subscription> subscription) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.DNI = DNI;
		this.birthdate = birthdate;
		this.email = email;
		this.status = status;
		this.password = password;
		this.img = img;
		this.age = age;
		this.bookings = bookings;
		this.payment = payment;
		this.bonos = bonos;
		this.subscription = subscription;
	}

	// Constructor empty

	public Users() {
	}

	public Users(String name, String surname, String phone, String DNI, String birthdate, String email, String img, int age) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.DNI = DNI;
		this.birthdate = birthdate;
		this.email = email;
		this.img = img;
		this.age = age;
	}

	public Users(@NotBlank(message = "El nombre no puede estar vacio cenutrio") String name,
				 @NotBlank(message = "Tienes que indicar un apellido") String surname, @NotBlank String phone,
				 @NotBlank String dNI, String birthdate, @Email @NotEmpty String email, @NotBlank String status,
				 String password, String img, int age, List<Booking> bookings) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		DNI = dNI;
		this.birthdate = birthdate;
		this.email = email;
		this.status = status;
		this.password = password;
		this.img = img;
		this.age = age;
		this.bookings = bookings;
	
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	

	

	public void setAge(int age) {
		this.age = age;
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

	public Users(long idusers, String name, String surname, String phone, String DNI, String birthdate, String email, String status, String password, String img, int age, List<Booking> bookings, List<Payments> payment, List<Bonos> bonos) {
		this.idusers = idusers;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.DNI = DNI;
		this.birthdate = birthdate;
		this.email = email;
		this.status = status;
		this.password = password;
		this.img = img;
		this.age = age;
		this.bookings = bookings;
		this.payment = payment;
		this.bonos = bonos;
		
	}

	public void setSubscription(List<Subscription> subscription) {
		this.subscription = subscription;
	}
// Getters and Setters


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

	public List<Payments> getPayment() {
		return payment;
	}

	public void setPayment(List<Payments> payment) {
		this.payment = payment;
	}

	public List<Bonos> getBonos() {
		return bonos;
	}

	public void setBonos(List<Bonos> bonos) {
		this.bonos = bonos;
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

	public List<Subscription> getSubscription() {
		return subscription;
	}

	
	

	//public void reviewbonus(Users userfound,Users usersave) {

		//if(userfound.getStatus() != null) {
		//	List<Bonos> bonos = userfound.getBonos();

		  //  for(Bonos bono : bonos) {
		    //	System.out.print(bono.getState());

		    //	if(bono.getState().equals("disponible")) {
		    //	   System.out.println("He encontrado uno");

		    //	   usersave.setStatus("SubscriptionON");
		    //	}
		    //}

		//	}else {
		//		usersave.setStatus("SubscriptionOF");
		//	}

	}

				




	


