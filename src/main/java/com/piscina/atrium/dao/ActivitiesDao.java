package com.piscina.atrium.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Activities;

public interface ActivitiesDao extends JpaRepository<Activities, Long> {

}
