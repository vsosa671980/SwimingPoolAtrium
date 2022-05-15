package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Subscription;

public interface ISubscription {
	
	public  ArrayList<Subscription>listSubscriptions();
	
	public void insertSubscription(Subscription subscription);
	
	public void removeSubscription(Long id);
	
	public Subscription foundSubscription(Long id);

}
