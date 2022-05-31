package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.models.Planning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
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

	@Override
	public ArrayList<Planning> listPStreet() {

		return dao.listplanning();
	}

	@Override
	public Page<Planning> listPlanningPageable(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public ArrayList<Planning> listBydate(String dateInit, String dateFinish) {
		return dao.listByDate(dateInit,dateFinish);
	}



}
