package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.services.StreetService;
import com.piscina.atrium.models.Street;

@Controller
@RequestMapping("/street")
public class StreetControll {
	
	@Autowired
    private StreetService dao;




	
	@GetMapping("/insert")
    public String formCreateStreet(Model model,Street street) {
    	
	    model.addAttribute("streetForm",street);

    	return "fragmentStreet :: modalStreet";
    }
	
	@PostMapping("/save")
	public String insertStreet(@ModelAttribute("streetForm") Street street,Model model) {
		
		dao.insertStreet(street);
		
		
		return "redirect:/street/list";
	}
	
	@GetMapping("/list")
	public String listStreet(Model model) {
		
		model.addAttribute("streets", dao.listStreets());
		
	
		return "/Street/listStreet";
		
	}
	@GetMapping("/delete/{id}")
	public String DeleteStreet(@PathVariable long id){

		dao.DeleteStreet(id);

		return "redirect:/street/list";
	}

	@GetMapping("/update/{id}")
	public String UpdateStreet(@PathVariable Long id,Street street,Model model){

		model.addAttribute("streetForm",dao.foundStreet(id));

       return "fragmentStreet :: modalStreet";
	}



}
