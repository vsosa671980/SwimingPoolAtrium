package com.piscina.atrium.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.bonosService;
import com.piscina.atrium.models.Bonos;
import com.piscina.atrium.models.Users;
import com.piscina.atrium.resources.AdminFiles;



@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService serveruser;

	@Autowired
	private AdminFiles files;
	
	@Autowired
	private bonosService bono;
	@Autowired
	private SubscriptionService serviceSub;

	// For list all Users
	@GetMapping("/listusers")
	public String listUser(Model model,@RequestParam(name="value",required=false) String value) {

        ArrayList<Subscription> sub =serviceSub.listall();
        
        for (Subscription subscription : sub) {
			
        	subscription.CheckStatusBonos();
        	serviceSub.saveSubscription(subscription);
        		
        	System.out.println(subscription.getState());
        	
		}

		//For set the status of User (If has a bonos active)

		String userfilter = null;
		if (value != null) {
			
			userfilter = "ok";
			model.addAttribute("filter", userfilter);
			model.addAttribute("userslist", serveruser.foundByName(value));
			
		}else {
		model.addAttribute("filter", userfilter);
		model.addAttribute("userslist", serveruser.listAllUsers());
		
		}


		return "listusers";
	}
	// For go to page form create user
	@GetMapping("/insertUser")
	public String insertUser(Users user, Model model) {

		model.addAttribute("empleadoForm", new Users());

		return "updateUser";

	}

	// For save news users
	@PostMapping("/saveUser")
	public String createUser(@Valid @ModelAttribute("empleadoForm") Users user, Errors error,
			@RequestParam("file") MultipartFile multipart) {

		
		if (error.hasErrors()) {
			
			System.out.println(error);

			return "updateUser";

		} else {
		
			// Guardamos el nombre de la imagen del usuario
			user.setImg(multipart.getOriginalFilename());
			// Calculamos la edad de el usuario y la guardamos en el usuario
			user.setAge();
			// Guardamos el archivo
			//files.saveFile(multipart);
			// Set the status of user about Bonus has
			
			Long identificacion = user.getIdusers();
			
			System.out.println(identificacion);
			
			
			//New user Object for found User if exits
			Users usuario = serveruser.foundUserByid(identificacion);
			
			//Obtain the list of Bonus

			List<Bonos> bonos = usuario.getBonos();

            
		    //save the User
			serveruser.insertUser(user);
			
			Long id = user.getIdusers();
			
			files.saveFile(multipart,id);

			return "redirect:/users/listusers";
		}
		
	}

	// For Update user

	// Automaticamente si existe el objeto inyecta y le asigna el id que le pasamos
	@GetMapping("/updateUser/{idusers}")
	public String updateUser(@PathVariable Long idusers, Model model) {

		model.addAttribute("empleadoForm", serveruser.foundUserByid(idusers));

		return "updateUser";	
	}
	
	// For delete Users
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@ModelAttribute("empleadoForm") Users user, @PathVariable long id) {
		
		
	//    System.out.println(serveruser.foundUserByid(id).getImg());
	   // String fichero = serveruser.foundUserByid(id).getImg();
//	    files.deleteFile(fichero);
//	    
		serveruser.deleteUser(id);
		return "redirect:/users/listusers";

	}
	
	@GetMapping("/found")
	public String busqueda() {
		
		return "Filtrado";
	}
	
	
	//For find byId;
	@GetMapping("/busqueda")
	public String busquedaporid(Model modelo,@RequestParam(name="value" ,required=false) String value) {
		
		System.out.println(value);
		
		modelo.addAttribute("user",serveruser.foundByName(value));
				
		return"busqueda";
		
	}
	

	

	// For found users actives

	@GetMapping("/user/activos")
	public ArrayList<Users> listActivos() {
		
		
		return serveruser.foundActivos();
	}

	// For find by name

	@GetMapping("/user/name/{name}")
	@ResponseBody
	public ArrayList<Users> Byname(@PathVariable String name) {

		return serveruser.foundByName(name);

	}

	@GetMapping("/user/status/{status}")
	public ArrayList<Users> ByStatus(@PathVariable String status) {

		return serveruser.foundByStatus(status);

	}

	@PutMapping("/user/edit/{id}")
	public Users edit(@RequestBody Users user, @PathVariable Long id) {

		return serveruser.update(user, id);

	}
	
@GetMapping("/obtener")
	@ResponseBody
	public ArrayList<Users> listado(Model model){
		
		
		
		return   serveruser.listAllUsers();
	}

	@GetMapping("/listbonos")
	public String BonosUsers(Model model){

		model.addAttribute("bonos",serveruser.listAllUsers());
		return "prueba";
	}
   
    }
    


