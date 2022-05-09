package com.piscina.atrium.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.piscina.atrium.dao.UsersDao;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.UsersServices;
import com.piscina.atrium.models.Users;
import com.piscina.atrium.resources.AdminFiles;

@Controller
public class UsersController {

	@Autowired
	private UserService serveruser;

	@Autowired
	private AdminFiles files;

	// For list all Users
	@GetMapping("/user/listusers")
	public String listUser(Model model,@RequestParam(name="value",required=false) String value) {
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
	@GetMapping("/user/insertUser")
	public String insertUser(Users user, Model model) {

		model.addAttribute("empleadoForm", new Users());

		return "updateUser";

	}

	// For save news users
	@PostMapping("/user/saveUser")
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
			// Guardamos al usuario
			serveruser.insertUser(user);
			
			Long id = user.getIdusers();
			
			files.saveFile(multipart,id);

			return "redirect:/user/listusers";
		}
	}

	// For Update user

	// Automaticamente si existe el objeto inyecta y le asigna el id que le pasamos
	@GetMapping("/user/updateUser/{idusers}")
	public String updateUser(@PathVariable Long idusers, Model model) {

		model.addAttribute("empleadoForm", serveruser.foundUserByid(idusers));

		return "updateUser";	
	}
	
	// For delete Users
	@GetMapping("/user/deleteUser/{id}")
	public String deleteUser(@ModelAttribute("empleadoForm") Users user, @PathVariable long id) {
		
		
	//    System.out.println(serveruser.foundUserByid(id).getImg());
	   // String fichero = serveruser.foundUserByid(id).getImg();
//	    files.deleteFile(fichero);
//	    
		serveruser.deleteUser(id);
		return "redirect:/user/listusers";

	}
	
	@GetMapping("/user/found")
	public String busqueda() {
		
		return "Filtrado";
	}
	
	
	//For find byId;
	@GetMapping("/user/busqueda")
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



   
    }
    


