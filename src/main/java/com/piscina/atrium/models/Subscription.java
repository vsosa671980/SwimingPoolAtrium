package com.piscina.atrium.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
public class Subscription {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
	private Long idSubscription;
	
    @Column(name="type_Subscription")
	private String typeSubscription;
	
    
    @Column(name = "subscription_cost")
	private double cost;
	
    
    @Column(name="subscription_state")
	private String state;
	
    
    @Column(name="subscription_duration")
	private int duration;
    
    
    //Relation witch Payment Class
    @OneToMany(mappedBy = "idSubscription",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Payments> payments ;
    
    //Relation ManyToMany witch User Class
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(
    		name ="subscription_Users",
    		joinColumns =@JoinColumn(name = "id_subscription"),
    		inverseJoinColumns = @JoinColumn(name="idusers")
  		
    		)    
    private List<Users> user  = new ArrayList<>();
   

    public Subscription() {

    }
    
    

    public Subscription(String typeSubscription, double cost, String state, int duration, List<Payments> payments,
			List<Users> user) {
		this.typeSubscription = typeSubscription;
		this.cost = cost;
		this.state = state;
		this.duration = duration;
		this.payments = payments;
		this.user = user;
	}



	public Subscription(Long idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Long getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Long idSubscription) {
        this.idSubscription = idSubscription;
    }

	public String getTypeSubscription() {
		return typeSubscription;
	}

	public void setTypeSubscription(String typeSubscription) {
		this.typeSubscription = typeSubscription;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}



	public List<Payments> getPayments() {
		return payments;
	}



	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}



	public List<Users> getUser() {
		return user;
	}



	public void setUser(List<Users> user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Subscription [idSubscription=" + idSubscription + ", typeSubscription=" + typeSubscription + ", cost="
				+ cost + ", state=" + state + ", duration=" + duration + ", payments=" + payments + ", user=" + user
				+ "]";
	}
	
	

	

	

	


	


    
}
