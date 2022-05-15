package com.piscina.atrium.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Planning;

public interface PlanningDao extends JpaRepository<Planning, Long> {

}
