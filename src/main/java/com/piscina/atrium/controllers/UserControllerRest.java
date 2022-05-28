package com.piscina.atrium.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.dao.services.PlanningService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Planning;
import com.piscina.atrium.models.Users;

@RestController
public class UserControllerRest {
	
	
	@Autowired
	private UserService serveruser;
	

	
	 @GetMapping("/prueba")
	    
	    public ArrayList<Users> lisusers (){
	    	
	    	return serveruser.listAllUsers();
	    	
	 }
	 
	 @GetMapping("/prueba/{name}")
		public ArrayList<Users> Byname(@PathVariable String name) {

			return serveruser.foundByName(name);

		}
	 
	 @Autowired
	    private PlanningService service;
	    
	    @Autowired
	    private PlanningDao dao;


	    @GetMapping("/prueba/list")
	    public ArrayList<Planning> listPlanning(){
	       
	    	return (ArrayList<Planning>) dao.findAll();
	    }

	 

	 
	    	

}
