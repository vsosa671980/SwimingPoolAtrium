package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.Optional;

import com.piscina.atrium.models.Bonos;

public interface Ibonos {
	
	public void insertBonos(Bonos bono);
	

	public ArrayList<Bonos> listBonos();

	public Bonos listById(Long id);

	public void DeleteBono(Long id);
	


}
