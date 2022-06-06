package com.piscina.atrium.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.bonosService;
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
	@GetMapping("/list")
	public String listUser(Model model, @RequestParam(name="value",required=false) String value, Pageable pageable,HttpSession session) {

		String state ="SubscriptionON";
		String stateOF ="SubscriptionOF";
		ArrayList<Users> users = serveruser.listAllUsers();
		session.getLastAccessedTime();
		for (Users users2 : users) {
			
			for (Subscription sub : users2.getSubscription()) {
				
				if (sub.getState().contains(state)) {
					users2.setStatus(state);
					
				}else {
					users2.setStatus(stateOF);
				}
			}
				
			}
		
		
		String userfilter = null;
		if (value != null) {
			
			userfilter = "ok";
			model.addAttribute("filter", userfilter);
			model.addAttribute("userslist", serveruser.foundByName(value));
			
		}else {
		model.addAttribute("filter", userfilter);
		model.addAttribute("userslist", serveruser.findAllPaginates(pageable));
		
		}

		return "/Users/listusers";
	}
	// For go to page form create user
	@GetMapping("/insert")
	public String insertUser(Users user, Model model) {

		model.addAttribute("empleadoForm", new Users());

		return "/Users/updateUser";

	}

	// For save news users
	@PostMapping("/save")
	public String createUser(@Valid @ModelAttribute("empleadoForm") Users user, Errors error,
			@RequestParam("file") MultipartFile multipart,Model model) {

		
		if (error.hasErrors()) {

			model.addAttribute("error",error);
			
			System.out.println(error);

			return "redirect:/users/list";

		} else {
		
			// Guardamos el nombre de la imagen del usuario
			user.setImg(multipart.getOriginalFilename());
			// Calculamos la edad de el usuario y la guardamos en el usuario
			user.setAge();
			// Guardamos el archivo
			//files.saveFile(multipart);

            if(user.getImg() == null ){
				user.setImg("avatar.gif");
			}
		    //save the User
			serveruser.insertUser(user);
			
			Long id = user.getIdusers();
			
			files.saveFile(multipart,id);

			return "redirect:/users/list";
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
		return "redirect:/users/list";

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

	@GetMapping("/userFile/{user}")
	public String userFile(@PathVariable Long user,Model model){

		model.addAttribute("users",serveruser.foundUserByid(user));

		return "/Users/userfile";
	}
   
    }
    


