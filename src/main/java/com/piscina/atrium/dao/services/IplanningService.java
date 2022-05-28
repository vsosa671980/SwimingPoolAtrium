package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Planning;


public interface IplanningService {
	
public  ArrayList<Planning>listPlanning();
	
	public void insertPlanning(Planning planning);

	
	public Planning foundPlannning(Long id);
	
	public void deletePlanning(Long id);

	public ArrayList<Planning> listPStreet();

}
