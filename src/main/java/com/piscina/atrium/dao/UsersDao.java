package com.piscina.atrium.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.piscina.atrium.models.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Long>, PagingAndSortingRepository<Users,Long> {

	@Query(value = "Select p FROM Users p WHERE p.username LIKE %?1% OR p.DNI LIKE %?1% ")
	Page<Users> searchByname(String filtro,Pageable pageable);

	@Query(value = "Select p FROM Users p WHERE p.status LIKE %?1%")
	ArrayList<Users> status(String status);



}
