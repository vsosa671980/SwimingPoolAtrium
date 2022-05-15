package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.models.Planning;

public class PlanningService  implements IplanningService{
	
	@Autowired
	private PlanningDao dao;

	@Override
	public ArrayList<Planning> listPlanning() {
		
		return (ArrayList<Planning>) dao.findAll();
	}

	@Override
	public void insertPlanning(Planning planning) {
		
		dao.save(planning);
		
	}


	@Override
	public Planning foundPlannning(Long id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deletePlanning(Long id) {
		
		dao.deleteById(id);
		
		
	}

}
