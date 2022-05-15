package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.BookingDao;
import com.piscina.atrium.dao.SubscriptionDao;
import com.piscina.atrium.models.Subscription;

@Service
public class SubscriptionService implements ISubscription {

	@Autowired
    private SubscriptionDao dao;

	@Override
	public ArrayList<Subscription> listSubscriptions() {
		
		return (ArrayList<Subscription>) dao.findAll();
	}

	@Override
	public void insertSubscription(Subscription subscription) {
		
		
		dao.save(subscription);
	}

	@Override
	public void removeSubscription(Long id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public Subscription foundSubscription(Long id) {
	
		return dao.findById(id).orElse(null);
	}
	
	

	

}
