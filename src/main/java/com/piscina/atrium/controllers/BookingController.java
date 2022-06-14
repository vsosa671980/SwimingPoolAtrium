package com.piscina.atrium.controllers;

import com.piscina.atrium.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.services.IBookingService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.models.Booking;
import com.piscina.atrium.models.Users;

@Controller
@RequestMapping("booking")
public class BookingController {
	
	
	@Autowired
	private IBookingService service;
	
	@Autowired
	private UserService serveruser;
	
	@GetMapping("/list/{iduser}")
	public String listReservas(Model model,@PathVariable Long iduser,Pageable pageable){

        System.out.println(iduser);
		model.addAttribute("Bookings",service.listByUser(iduser,pageable));

		return "/Bookings/listbooking :: list";

	}
	@GetMapping("/list")
	public String listAllBokings(Model model,Pageable pageable){


		model.addAttribute("Bookings",service.listBookings(pageable));

		return "/Bookings/listbooking";

	}


	@GetMapping("/insert")
	public String createBooking(@RequestParam("iduser") Users user,@RequestParam("idplanning")Planning planning,Model model, Booking booking) {


			booking.setIdusers(user);
			booking.setPlannings(planning);

		  if(planning.getOcupacion() >0) {
			planning.setOcupacion(planning.getOcupacion() - 1);
		}
			service.insertBooking(booking);
			
			return "Congratulations/payCorrect";

	}

	

	
		
		
	}
	
	
	
	
	

	

