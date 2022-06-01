package com.piscina.atrium.resources;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Subscription;
import com.piscina.atrium.models.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.TimerTask;

public class Task extends TimerTask {


    @Autowired
    private UserService userService;

    @Override
    public void run() {
    	
    	String state ="SubscriptionON";
		String stateOF ="SubscriptionOF";
		ArrayList<Users> users = userService.listAllUsers();
		
		for (Users users2 : users) {
			
			for (Subscription sub : users2.getSubscription()) {
				
				if (sub.getState().contains(state)) {
					users2.setStatus(state);
					
				}else {
					users2.setStatus(stateOF);
				}
			}
				
			}



        }

    }

