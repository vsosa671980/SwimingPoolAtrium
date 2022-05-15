package com.piscina.atrium.models;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.CustomLog;
import lombok.Data;

@Data
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

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "id_subscription")
    private Subscription idSubscription ;


   public Payments() {
   }


public Payments(String typePay, LocalDate datePay, String statePay, double pay) {
    this.typePay = typePay;
    this.datePay = datePay;
    this.statePay = statePay;
    this.pay = pay;

}


    public Payments(String typePay, LocalDate datePay, String statePay, double pay, Subscription idSubscription) {
	this.typePay = typePay;
	this.datePay = datePay;
	this.statePay = statePay;
	this.pay = pay;
	this.idSubscription = idSubscription;
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


@Override
public String toString() {
	return "Payments [idPayment=" + idPayment + ", typePay=" + typePay + ", datePay=" + datePay + ", statePay="
			+ statePay + ", pay=" + pay + ", idSubscription=" + idSubscription + "]";
}


   
   


}
