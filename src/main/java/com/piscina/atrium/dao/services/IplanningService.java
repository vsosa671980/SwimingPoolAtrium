package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Planning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IplanningService {
	
public  ArrayList<Planning>listPlanning();
	
	public void insertPlanning(Planning planning);

	
	public Planning foundPlannning(Long id);
	
	public void deletePlanning(Long id);

	public ArrayList<Planning> listPStreet();

	public Page<Planning> listPlanningPageable(Pageable pageable);

	public ArrayList<Planning> listBydate(String dateInit,String dateFinish);


}
