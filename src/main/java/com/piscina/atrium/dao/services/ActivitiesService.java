package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piscina.atrium.dao.ActivitiesDao;
import com.piscina.atrium.models.Activities;

@Service
public class ActivitiesService  implements IActivitiesService{
	
	
	@Autowired
	private ActivitiesDao dao;

	@Override
	public ArrayList<Activities> listActivities() {
		
		return (ArrayList<Activities>) dao.findAll() ;
	}

	@Override
	public void insertActivity(Activities activity) {
		
		dao.save(activity);
	}

	@Override
	public void removeActivity(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Activities foundActivity(Long id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteActivity(Long id) {
		
		dao.deleteById(id);
		
	}

}
