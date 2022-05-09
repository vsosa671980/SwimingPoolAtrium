package com.piscina.atrium.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.piscina.atrium.dao.BookingDao;
import com.piscina.atrium.models.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;


@Repository
public class IBookingService implements BookingService {
   

    //Inyect Dao Variable
    @Autowired
    private BookingDao bookingDao;

	@Override
	public ArrayList<Booking> listAllBookkings() {
		
		return (ArrayList<Booking>) bookingDao.findAll();
	}

	@Override
	public void insertBooking1(Booking booking) {
		
		bookingDao.save(booking);
		
	}

	@Override
	public void deleteBooking(Long id) {
	  
		
		bookingDao.deleteById(id);
		
	}

	@Override
	public void insertBooking(Booking booking) {
		
		bookingDao.save(booking);
		
	}

	@Override
	public ArrayList<Booking> listAllBook() {
		
		return bookingDao.findBooking();
	}

	@Override
	public ArrayList<Booking> usersBookings(long id) {
		
		return bookingDao.userbookings(id);
		
		}
    
    




    
}
