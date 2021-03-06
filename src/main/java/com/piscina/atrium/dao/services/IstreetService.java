package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.piscina.atrium.models.Street;

@Service
public interface IstreetService {
	
	public ArrayList<Street> listStreets();
	
	public void DeleteStreet(Long id);
	
	public void insertStreet(Street street);

	public Optional<Street> foundStreet(Long id);
	
  

}
