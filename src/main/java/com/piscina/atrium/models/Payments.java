package com.piscina.atrium.models;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Payments {
  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_payment")
   private Long idPayment;

   @NotNull
   @Column(name = "type_pay")   
   private String typePay;
   
   @Column(name="date_pay")
   private LocalDate datePay;
   
   @Column(name="state_pay")
   private String statePay;
	@NotNull
   @Column(name = "pay")
   private double pay;

    @ManyToOne()
    @JoinColumn(name = "idBonos")
    private Bonos bonos ;
    
    @ManyToOne()
    @JoinColumn(name="idusers")
    private Users idu;


   public Payments() {
   }
   

public Payments(Long idPayment, String typePay, LocalDate datePay, String statePay, double pay, Bonos bonos,
		Users idu) {
	this.idPayment = idPayment;
	this.typePay = typePay;
	this.datePay = datePay;
	this.statePay = statePay;
	this.pay = pay;
	this.bonos = bonos;
	this.idu = idu;
}


public Payments(String typePay, LocalDate datePay, String statePay, double pay, Bonos bonos, Users idu) {
	this.typePay = typePay;
	this.datePay = datePay;
	this.statePay = statePay;
	this.pay = pay;
	this.bonos = bonos;
	this.idu = idu;
}



public Long getIdPayment() {
	return idPayment;
}


public void setIdPayment(Long idPayment) {
	this.idPayment = idPayment;
}


public String getTypePay() {
	return typePay;
}


public void setTypePay(String typePay) {
	this.typePay = typePay;
}


public LocalDate getDatePay() {
	return datePay;
}


public void setDatePay(LocalDate datePay) {
	this.datePay = datePay;
}


public String getStatePay() {
	return statePay;
}


public void setStatePay(String statePay) {
	this.statePay = statePay;
}


public double getPay() {
	return pay;
}


public void setPay(double pay) {
	this.pay = pay;
}



public Users getIdu() {
	return idu;
}


public void setIdu(Users idu) {
	this.idu = idu;
}

	public Bonos getBonos() {
		return bonos;
	}

	public void setBonos(Bonos bonos) {
		this.bonos = bonos;
	}
}
