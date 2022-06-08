package com.piscina.atrium.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Users;

public interface UsersSecurityDao extends JpaRepository<Users, Long>{
	
	Optional<Users>findByUsername(String username);

}
