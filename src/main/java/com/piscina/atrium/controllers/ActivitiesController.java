package com.piscina.atrium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.piscina.atrium.dao.services.ActivitiesService;
import com.piscina.atrium.models.Activities;

@Controller
@RequestMapping("activities")
public class ActivitiesController {
	
	@Autowired
	private ActivitiesService service;

    @GetMapping("/")
    public String Activities(Model model) {
    	
    	model.addAttribute("activities",service.listActivities() );

        return "/Activities/activities";
    }

    @GetMapping("/insert")
    public String ActivityForm(Model model,Activities activity){

        model.addAttribute("activityForm", activity);

        return "fragmentActivities :: modalActivity";

    }

    @PostMapping("/save")
    public String saveActivity(@ModelAttribute("activityForm") Activities activity){

        service.insertActivity(activity);

        return "redirect:/activities/";
    }
    
    

}
