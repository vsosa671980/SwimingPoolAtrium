package com.piscina.atrium.models;

import java.time.LocalDate;

import javax.persistence.*;

import org.apache.catalina.User;

import lombok.CustomLog;
import lombok.Data;


@Entity
public class Payments {
  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_payment")
   private Long idPayment;
   
   @Column(name = "type_pay")   
   private String typePay;
   
   @Column(name="date_pay")
   private LocalDate datePay;
   
   @Column(name="state_pay")
   private String statePay;
   
   @Column(name = "pay")
   private double pay;

    @ManyToOne()
    @JoinColumn(name = "id_subscription")
    private Subscription idSubscription ;
    
    @ManyToOne()
    @JoinColumn(name="idusers")
    private Users idu;


   public Payments() {
   }


public Payments(Long idPayment, String typePay, LocalDate datePay, String statePay, double pay,
		Subscription idSubscription, Users idu) {
	this.idPayment = idPayment;
	this.typePay = typePay;
	this.datePay = datePay;
	this.statePay = statePay;
	this.pay = pay;
	this.idSubscription = idSubscription;
	this.idu = idu;
}




public Payments(String typePay, LocalDate datePay, String statePay, double pay, Subscription idSubscription,
		Users idu) {
	this.typePay = typePay;
	this.datePay = datePay;
	this.statePay = statePay;
	this.pay = pay;
	this.idSubscription = idSubscription;
	this.idu = idu;
}




public Payments(LocalDate datePay, Subscription idSubscription, Users idu) {
	this.datePay = datePay;
	this.idSubscription = idSubscription;
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


public Subscription getIdSubscription() {
	return idSubscription;
}


public void setIdSubscription(Subscription idSubscription) {
	this.idSubscription = idSubscription;
}


public Users getIdu() {
	return idu;
}


public void setIdu(Users idu) {
	this.idu = idu;
}




   



   
   


}
