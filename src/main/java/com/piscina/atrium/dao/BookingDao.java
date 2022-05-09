package com.piscina.atrium.dao;

import java.util.ArrayList;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.piscina.atrium.models.Booking;
import com.piscina.atrium.models.Users;


@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM bookings ", nativeQuery = true)
    ArrayList<Booking> findBooking();
    
    @Query(value = "SELECT * FROM bookings inner Join Users on users.idusers = bookings.idusers WHERE Users.idusers LIKE %:filtro%", nativeQuery = true)
    ArrayList<Booking> userbookings(@Param("filtro") Long id);
	
	
	
}


//@Query(value = "SELECT * FROM bookings inner Join Users on bookings.idusers = users.idusers", nativeQuery = true)
//ArrayList<Booking> findBooking();