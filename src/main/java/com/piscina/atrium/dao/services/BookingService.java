package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.models.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService  {

    public Page<Booking> listAllBookkings(Pageable pageable,long iduser);

    public void insertBooking1(Booking booking);

    public void deleteBooking(Long id);

	void insertBooking(Booking booking);

	
	public ArrayList<Booking> usersBookings(long id);

    public Page<Booking> listAllBookPageable(Pageable pageable);

    public Page<Booking> listBookings(Pageable pageable);

    public Page<Booking> listByUser(Long id,Pageable pageable);
   
    
}
