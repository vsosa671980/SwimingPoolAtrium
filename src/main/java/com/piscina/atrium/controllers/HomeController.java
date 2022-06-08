package com.piscina.atrium.controllers;

import com.piscina.atrium.models.Users;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/index")
	public String home(@AuthenticationPrincipal Users user) {

		System.out.println(user);

		return "index";
	}

}
