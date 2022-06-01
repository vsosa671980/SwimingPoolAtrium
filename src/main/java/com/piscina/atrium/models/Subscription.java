package com.piscina.atrium.models;

import javax.annotation.Generated;
import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;

@Entity
@Table(name="subscription")
public class Subscription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_subscription")
    private Long idSubscription;
    

   @Column(name = "init_day") 
    private LocalDate initDay;
    
    @Column(name="finishday")
    private LocalDate finishday;

    @Column(name="state")
    private String state;
     

    @ManyToOne()
    @JoinColumn(name="idusers") 
    private Users user;

    public Subscription() {
    }

    public Subscription(LocalDate initDay, LocalDate finishday, Users user) {
        this.initDay = initDay;
        this.finishday = finishday;
        this.user = user;
    }

    public Subscription(LocalDate initDay, LocalDate finishday, String state, Users user) {
        this.initDay = initDay;
        this.finishday = finishday;
        this.state = state;
        this.user = user;
    }

    public Long getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Long idSubscription) {
        this.idSubscription = idSubscription;
    }

    public LocalDate getInitDay() {
        return initDay;
    }

    public void setInitDay(LocalDate initDay) {
        this.initDay = initDay;
    }

    public LocalDate getFinishday() {
        return finishday;
    }

    public void setFinishday(LocalDate finishday) {
        this.finishday = finishday;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String CheckStatusBonos(){

        LocalDate date = LocalDate.now();

        if(this.finishday.isAfter(date)){
            state =  "SubscriptionON";
        }else
            state = "SubscriptionOF";

        return state;
    }

}
