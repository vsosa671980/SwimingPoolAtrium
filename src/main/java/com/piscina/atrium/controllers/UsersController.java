package com.piscina.atrium.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.piscina.atrium.dao.services.RolesService;
import com.piscina.atrium.dao.services.SubscriptionService;
import com.piscina.atrium.models.Roles;
import com.piscina.atrium.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.bonosService;
import com.piscina.atrium.models.Users;
import com.piscina.atrium.resources.AdminFiles;
import com.piscina.atrium.resources.EncrypPassword;



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

	@Autowired
	private RolesService rolesService;

	// For list all Users
	@GetMapping("/list")
	public String listUser(Model model, @RequestParam(name = "value", required = false) String value, Pageable pageable) {

		String state = "SubscriptionON";
		String stateOF = "SubscriptionOF";
		ArrayList<Users> users = serveruser.listAllUsers();

		for (Users users2 : users) {

			for (Subscription sub : users2.getSubscription()) {

				if (sub.getState().contains(state)) {
					users2.setStatus(state);

				} else {
					users2.setStatus(stateOF);
				}
			}

		}

		String userfilter = null;
		if (value != null) {

			userfilter = "ok";
			model.addAttribute("filter", userfilter);
			model.addAttribute("pageable", serveruser.foundByName(value, pageable));

		} else {
			model.addAttribute("filter", userfilter);
			model.addAttribute("pageable", serveruser.findAllPaginates(pageable));

		}

		return "/Users/listusers";
	}

	// For go to page form create user
	@GetMapping("/insert")
	public String insertUser(Users user, Model model, Roles roles) {

		model.addAttribute("empleadoForm", new Users());
		model.addAttribute("roles", rolesService.findRoles());
		return "/Users/updateUser";

	}

	// For save news users
	@PostMapping("/save")
	public String createUser(@Valid @ModelAttribute("empleadoForm") Users user, Errors error,
							 @RequestParam("file") MultipartFile multipart, Model model) {


		if (error.hasErrors()) {

			model.addAttribute("error", error);

			return "redirect:/users/list";

		} else {

			// Guardamos el nombre de la imagen del usuario
			user.setImg(multipart.getOriginalFilename());
			// Calculamos la edad de el usuario y la guardamos en el usuario
			user.setAge();
			// Guardamos el archivo
			//files.saveFile(multipart);
		}
		if (user.getImg() == null) {
			user.setImg("avatar.gif");
		}
		//For set the Role for Default if User is no create for Admin User
		if (user.getRoles().size() == 0) {

			Roles rol = rolesService.findRoleByName("USER");
			ArrayList<Roles> roles = new ArrayList<>();
			roles.add(rol);

			user.setRoles(roles);
		}
		//Password for default for example program
		String password = "1234";

		//Encrypt the password
		user.setPassword(EncrypPassword.passwordEncoder(password));

		//For make a carpet to insert the images of user
		Long id = user.getIdusers();

		files.saveFile(multipart, id);

		//Save the user

		serveruser.insertUser(user);

		return "redirect:/users/list";


	}

	// For Update user
	@GetMapping("/updateUser/{idusers}")
	public String updateUser(@PathVariable Long idusers, Model model) {

		model.addAttribute("empleadoForm", serveruser.foundUserByid(idusers));
		model.addAttribute("roles",rolesService.findRoles());

		return "/Users/updateUser";
	}
	
	// For delete Users
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@ModelAttribute("empleadoForm") Users user, @PathVariable long id) {

		serveruser.deleteUser(id);
		return "redirect:/users/list";

	}
	
	@GetMapping("/found")
	public String busqueda() {
		
		return "Filtrado";
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
    


