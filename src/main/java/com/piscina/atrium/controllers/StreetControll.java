package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.piscina.atrium.dao.services.StreetService;
import com.piscina.atrium.models.Street;

@Controller
@RequestMapping("/street")
public class StreetControll {
	
	@Autowired
    private StreetService dao;
    
	
	@GetMapping("/create")
    public String formCreateStreet(Model model) {
    	
		model.addAttribute("streetform", new Street());
    	return "updatestreet";
    }
	
	@PostMapping("/insert")
	public String insertStreet(@ModelAttribute("streetform") Street street,Model model) {
		
		dao.insertStreet(street);
		
		
		return "listUsers";
	}
	
	@GetMapping("/listStreet")
	public String listStreet(Model model) {
		
		model.addAttribute("streets", dao.listStreets());
		
	
		return "/Street/streetlist";
		
	}



}
