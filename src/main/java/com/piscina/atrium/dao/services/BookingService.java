package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Booking;

public interface BookingService  {

    public ArrayList<Booking> listAllBookkings();

    public void insertBooking1(Booking booking);

    public void deleteBooking(Long id);

	void insertBooking(Booking booking);
	
	public ArrayList<Booking> listAllBook();
	
	public ArrayList<Booking> usersBookings(long id);
	

   
    
}
