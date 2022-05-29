package com.piscina.atrium.controllers;

import javax.websocket.server.PathParam;

import com.piscina.atrium.models.Payments;
import com.piscina.atrium.resources.AdminFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.bonosService;
import com.piscina.atrium.models.Bonos;
import com.piscina.atrium.models.Users;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

@RequestMapping("/bono")
@Controller
public class BonosController {
	
	@Autowired
	private bonosService service;

	@Autowired
	private AdminFiles files;
	
	
	@Autowired
	private UserService uservice;

	
	@GetMapping("/list/{id}")
	public String ListBonosByUser(@PathVariable Long id,Model modelo,Users user) {
		
		user = uservice.foundUserByid(id);
		
		modelo.addAttribute("user" ,user.getBonos());
		
		
		return "prueba";
	}
	
	@GetMapping("/insert")
	public String bonosForm(Model model,Bonos bono) {
		
		model.addAttribute("bonusForm",bono);
		
		return "fragmentbonos :: modalBonus";
		
	}
	
	@GetMapping("/list")
	public String ListBonosByUser(Model modelo,Bonos bono) {

		modelo.addAttribute("bonos" , service.listBonos());
	
		return "/Bono/bono";
	}


	@PostMapping("/save")
	public String saveBono(@ModelAttribute("bonusForm") Bonos bono, @RequestParam("file")MultipartFile multipart){

		  //Save the name of img
		  bono.setImg(multipart.getOriginalFilename());
		  //Save the file

          service.insertBonos(bono);

		  //Obtein ID for Images name
		  Long id = bono.getIdBonos();
		  //Save the image in the directory
		  files.saveFile(multipart,id);

		  return "redirect:/bono/list";


	}

	@GetMapping("/buy/{idusers}")
	private String selectBono(@PathVariable Long idusers, Bonos bono,Model model){

		model.addAttribute("idu",idusers);
		model.addAttribute("bonos" , service.listBonos());

		return "/Bono/bono";

	}

	@GetMapping("/payment")
	private String buyBono (@RequestParam("iduser")Long iduser,@RequestParam("idbono")Long idbono,Payments payment,Model model){

        System.out.println(iduser);
		System.out.print(idbono);
		LocalDate date = LocalDate.now();
        payment.setDatePay(date);

	    Bonos bono = service.listById(idbono);
        payment.setBonos(bono);

		double cost = bono.getCostBonos();
		payment.setPay(cost) ;

		Users user = uservice.foundUserByid(iduser);
		payment.setIdu(user);

		model.addAttribute("date",date);

        model.addAttribute("idu",iduser);

		model.addAttribute("paymentForm",payment);

		return "paymentForm";
	}


	
	
}
