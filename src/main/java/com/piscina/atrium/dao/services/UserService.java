package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.UsersDao;
import com.piscina.atrium.models.Users;

@Service
public class UserService implements UsersServices {

	@Autowired
	private UsersDao userdao;
	

    //For list All Users
	@Override
	public ArrayList<Users> listAllUsers() {

		return (ArrayList<Users>) userdao.findAll();
	}
   
	
	//For Save Users
	@Override
	public Users insertUser(Users user) {
		userdao.save(user);
		return null;
	}
    
	
	
	//For Update USers
	@Override
	public Users updateUsers(Users user) {

		return null;
	}
    
	
	//For find by id
	@Override
	public Users foundUserByid(Long id) {

		return userdao.findById(id).orElse(null);

	}
    
	
	//For delete Users by Id
	@Override
	public void deleteUser(Long id) {

		userdao.deleteById(id);
		

	}

	@Override
	public ArrayList<Users> foundActivos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Users> foundByName(String name) {
		
		return userdao.searchByname(name);
	}

	@Override
	public ArrayList<Users> foundByStatus(String status) {
		// TODO Auto-generated method stub
		return userdao.status(status);
	}
    
	@Override
	public Users update(Users user,Long id) {
	   if (userdao.existsById(id)) {
		   user.setIdusers(id);
		 return  userdao.save(user);
		
	} else {
		return null;
	}
	}




	

}
