package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.BonosDao;
import com.piscina.atrium.models.Bonos;
@Service
public class bonosService implements Ibonos{
	
	@Autowired
	private BonosDao dao;


	@Override
	public void insertBonos(Bonos bono) {
		
		
		dao.save(bono);
      
		
	}

	@Override
	public ArrayList<Bonos> listBonos() {
		 
		return (ArrayList<Bonos>) dao.findAll();
		
	}

	@Override
	public Bonos listById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void DeleteBono(Long id) {
		dao.deleteById(id);
	}


}


