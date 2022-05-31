package com.piscina.atrium.dao.services;

import java.util.ArrayList;

import com.piscina.atrium.dao.BookingDao;
import com.piscina.atrium.models.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public class IBookingService implements BookingService {
   

    //Inyect Dao Variable
    @Autowired
    private BookingDao bookingDao;


	@Override
	public Page<Booking> listAllBookkings(Pageable pageable, long iduser) {
		return null;
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
	public ArrayList<Booking> usersBookings(long id) {
		
		return bookingDao.userbookings(id);
		
		}

	@Override
	public Page<Booking> listAllBookPageable(Pageable pageable) {

		return  bookingDao.findAll(pageable);
	}

	@Override
	public Page<Booking> listBookings(Pageable pageable) {

		return bookingDao.findAll(pageable);
	}

	@Override
	public Page<Booking> listByUser(Long id,Pageable pageable) {

		return bookingDao.findByuser(id,pageable);
	}


}
