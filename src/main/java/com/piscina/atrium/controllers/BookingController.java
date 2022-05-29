package com.piscina.atrium.controllers;

import java.awt.print.Book;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import com.piscina.atrium.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.BookingDao;
import com.piscina.atrium.dao.services.IBookingService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Booking;
import com.piscina.atrium.models.Users;

@Controller
public class BookingController {
	
	
	@Autowired
	private IBookingService service;
	
	@Autowired
	private UserService serveruser;
	
	@GetMapping("/user/reservas/listall")
	public String listReservas(Model model){
		 		
		model.addAttribute("Bookings",service.listAllBook());


		return "listbooking";
		
		
	}

	@GetMapping("/booking/insert")
	public String createBooking(@RequestParam("iduser") Users user,@RequestParam("idplanning")Planning planning,Model model, Booking booking) {


			booking.setIdusers(user);
			booking.setPlannings(planning);

			planning.setOcupacion(planning.getOcupacion() - 1);

			service.insertBooking(booking);
			
			return "Congratulations/payCorrect";

	}

	
	@GetMapping("booking/user/{id}")
	public String userboookings(@PathVariable long id ,Model model){
		
		
		model.addAttribute("Bookings", service.usersBookings(id)) ;
		
		 return "listbooking :: listbooks";
	}
	
		
		
	}
	
	
	
	
	

	

