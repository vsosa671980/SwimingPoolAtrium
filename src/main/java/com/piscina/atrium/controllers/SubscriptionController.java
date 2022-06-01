package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.piscina.atrium.dao.services.SubscriptionService;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	
	
	@Autowired
	private SubscriptionService service;

	
	@GetMapping("/list/{iduser}")
	public String listByUser(@PathVariable Long iduser,Model model) {
		
		model.addAttribute("subscription", service.listSubscriptionsUser(iduser));
		
		
		return "/Subscriptions/FragmentSubscription";
	}
	
	
}
