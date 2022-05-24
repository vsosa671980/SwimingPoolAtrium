package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.StreetDao;
import com.piscina.atrium.models.Street;

@Service
public class StreetService implements IstreetService{
	
	
	@Autowired
	private StreetDao dao;

	@Override
	public ArrayList<Street> listStreets() {
		
		return (ArrayList<Street>) dao.findAll();
	}

	@Override
	public void DeleteStreet(Long id) {
		
		 dao.deleteById(id);
		
	}

	@Override
	public void insertStreet(Street street) {
	
		 dao.save(street);
	}

	@Override
	public Optional<Street> foundStreet(Long id) {
		return dao.findById(id);
	}


}
