package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Activities;


public interface IActivitiesService {
	
	public  ArrayList<Activities>listActivities();
	
	public void insertActivity(Activities activity);
	public void removeActivity(Long id);
	
	public Activities foundActivity(Long id);
	
	public void deleteActivity(Long id);

}
