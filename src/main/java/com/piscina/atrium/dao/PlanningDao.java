package com.piscina.atrium.dao;

import com.piscina.atrium.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Planning;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PlanningDao extends JpaRepository<Planning, Long> {


}
