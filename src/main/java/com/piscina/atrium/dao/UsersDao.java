package com.piscina.atrium.dao;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.css.CSSUnknownRule;

import com.piscina.atrium.models.Users;

import antlr.collections.List;

@Repository
public interface UsersDao extends JpaRepository<Users, Long>{
	
	
	@Query(value = "Select p FROM Users p WHERE p.name LIKE %?1% OR p.DNI LIKE %?1% ")
	ArrayList<Users> searchByname(String filtro);
	
	@Query(value = "Select p FROM Users p WHERE p.status LIKE %?1%")
	ArrayList<Users> status(String status);
	
	
	
	

	

	
	
	
	

}
