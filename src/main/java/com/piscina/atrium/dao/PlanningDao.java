package com.piscina.atrium.dao;

import com.piscina.atrium.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Planning;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PlanningDao extends JpaRepository<Planning, Long> {

    @Query(value="select * from planning p inner join planning_street ps on p.id_planning = ps.id_planning join street s on ps.id_street=s.id_street;",nativeQuery = true)
    ArrayList<Planning> listplanning();

    @Query(value = "Select * From Planning p WHERE p.planning_day BETWEEN   ?1 AND  ?2",nativeQuery = true)
    ArrayList<Planning>listByDate(String filtro,String filtro2);



}
