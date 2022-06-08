package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.piscina.atrium.models.Users;


@Service
public interface UsersServices {
	
	public ArrayList<Users> listAllUsers();
	
	public void deleteUser(Long id);
	
	public Users insertUser(Users user);
	
	public Users foundUserByid(Long id);
	
	public Users updateUsers(Users user);
	
	public ArrayList<Users> foundActivos();

	Page<Users> foundByName(String name, Pageable pageable);

	public Page<Users> findAllPaginates(Pageable pageable);
	
	public ArrayList<Users> foundByStatus(String status);
	
	public Users update (Users user,Long id);

	

	
	

	



}
