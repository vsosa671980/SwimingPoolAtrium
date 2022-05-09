package com.piscina.atrium.controllers;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.piscina.atrium.dao.services.IBookingService;

@Controller
class FragmentsController {
	
	
	@Autowired
	private IBookingService booking;
	
	@GetMapping("/fragmento")
	public  String showFragment(Model model) {
		
		String casa = "Grande";
		
		model.addAttribute("Bookings",booking.listAllBook());
		return "listbooking :: listbooks";
	}

}
