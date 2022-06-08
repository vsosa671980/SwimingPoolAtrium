package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.UsersDao;
import com.piscina.atrium.models.Users;

@Service
public class UserService implements UsersServices {

	@Autowired
	private UsersDao dao;
	

    //For list All Users
	@Override
	public ArrayList<Users> listAllUsers() {

		return (ArrayList<Users>) dao.findAll();
	}
   
	
	//For Save Users
	@Override
	public Users insertUser(Users user) {
		dao.save(user);
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

		return dao.findById(id).orElse(null);

	}
    
	
	//For delete Users by Id
	@Override
	public void deleteUser(Long id) {

		dao.deleteById(id);
		

	}

	@Override
	public ArrayList<Users> foundActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Users> foundByName(String name, Pageable pageable) {
		return dao.searchByname(name,pageable);
	}


	@Override
	public Page<Users> findAllPaginates(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public ArrayList<Users> foundByStatus(String status) {
		// TODO Auto-generated method stub
		return dao.status(status);
	}
    
	@Override
	public Users update(Users user,Long id) {
	   if (dao.existsById(id)) {
		   user.setIdusers(id);
		 return  dao.save(user);
		
	} else {
		return null;
	}
	}




	

}
