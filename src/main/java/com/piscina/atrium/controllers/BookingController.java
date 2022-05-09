package com.piscina.atrium.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.piscina.atrium.dao.BookingDao;
import com.piscina.atrium.dao.services.IBookingService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Booking;
import com.piscina.atrium.models.Users;

@Controller
public class BookingController {
	
	
	@Autowired
	private IBookingService booking;
	
	@Autowired
	private UserService serveruser;
	
	@GetMapping("user/reservas/listall")
	public String listReservas(Model model){
		 		
		model.addAttribute("Bookings",booking.listAllBook());
			
		return "listbooking";
		
		
	}

	@GetMapping("booking/create/{idusers}")
	public String createBooking(@PathVariable Users idusers,Model model) {
		
		Booking booking = new Booking();
		
		booking.setIdusers(idusers);
		
			
        model.addAttribute("bookingForm", booking);
		return "bookingCreate";
	}
	
	@PostMapping("booking/insert")
	public String saveReserva(@ModelAttribute("bookingForm") Booking book) {	

		booking.insertBooking(book);	
		
		return  "redirect:/user/reservas/listall";
	
	}
	
	@GetMapping("booking/user/{id}")
	public String userboookings(@PathVariable long id ,Model model){
		
		
		model.addAttribute("Bookings", booking.usersBookings(id)) ;
		
		 return "listbooking :: listbooks";
	}
	
		
		
	}
	
	
	
	
	

	

