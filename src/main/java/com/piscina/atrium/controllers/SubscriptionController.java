package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Subscription;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

	
	@Autowired
	private SubscriptionService service;
	
	
	@GetMapping("/list")
	public String findSubscription(Model model) {
		
		model.addAttribute("subscriptions", service.listSubscriptions());
		
		return "/Subscription/listSubscriptions";
	}
	
	
	@GetMapping("/insert")
	public String tableInsert(Model modelo, Subscription subscription) {
		
		  modelo.addAttribute("subscriptionForm", subscription);
		
		return "/Subscription/formSubscription";		
	}
	
	@PostMapping("/save")
	public String saveSubscription(@ModelAttribute("subscriptionForm") Subscription subscription,Model model) {
		
		service.insertSubscription(subscription);
		
		
		return "redirect:/Subscription/listsubscription";
	}
	
}
