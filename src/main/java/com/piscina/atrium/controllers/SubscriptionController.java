package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Payments;
import com.piscina.atrium.models.Subscription;
import com.piscina.atrium.models.Users;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

	
	@Autowired
	private SubscriptionService service;
	
	
	@Autowired
	private UserService serviceUser;


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

	@GetMapping("/buy/{userid}")
	public String listSubscriptions(@PathVariable Long userid, Model model){
        
		System.out.println(userid);
		model.addAttribute("userId",userid);
		model.addAttribute("subscriptions",service.listSubscriptions());
		return "/Subscription/subscriptionsList";
		
		
	}

	@GetMapping("/comfirmbuy/")
	public String ConfirmBuy(@RequestParam("user") Long idUser ,@RequestParam("subscription") Long idSubscription,Model model,Payments payment,Users user){
			
       System.out.println(idSubscription);
       System.out.println(idUser);
       Subscription sub = service.foundSubscription(idSubscription);
       System.out.println(sub.getTypeSubscription());
       model.addAttribute("namesubscription",sub);
       
       model.addAttribute("paymentForm",payment);
       
       LocalDate date = LocalDate.now();
       
       ArrayList <String> tipesPayments =new ArrayList<>();
       
       String typePaymentOne = "contado";
       String typePaymentTwoo = "targeta";
       
       tipesPayments.add(typePaymentTwoo);
       tipesPayments.add(typePaymentOne);
       
       payment.setDatePay(date);
       payment.setIdSubscription(sub);
       payment.setPay(sub.getCost());
       
       user = serviceUser.foundUserByid(idUser);
       
       payment.setIdu(user);

		
		return "paymentForm";



	}
	
}
