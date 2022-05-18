package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Subscription;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

	
	@Autowired
	private SubscriptionService service;


	//Controller for view Subscriptions and create its



	//For list the subscriptions
	@GetMapping("/")
	public String mainsSubsccriptions(Model model) {
		
		model.addAttribute("subscriptions", service.listSubscriptions());

		return "/Subscription/subscription";
	}
	
	
	@GetMapping("/insert")
	public String tableInsert(Model model, Subscription subscription) {
		
		  model.addAttribute("subscriptionForm", subscription);
		
		 return "fragments :: formSubscription ";		
	}
	
	@PostMapping("/save")
	public String saveSubscription(@ModelAttribute("subscriptionForm") Subscription subscription,Model model) {
		
		service.insertSubscription(subscription);
		
		
		return "redirect:/subscriptions/";
	}
	@GetMapping("/delete/{id}")
		public String DeleteSubscription (@PathVariable Long id){

		service.removeSubscription(id);

		return "redirect:/subscriptions/";

	}

	@GetMapping("/update/{id}")
	public String updateSubscription(@PathVariable Long id, Model model){

		model.addAttribute("subscriptionForm",service.foundSubscription(id));


		return "fragments :: formSubscription ";

	}
	
}
