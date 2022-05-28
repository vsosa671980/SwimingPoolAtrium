package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.PlanningDao;
import com.piscina.atrium.dao.services.PlanningService;
import com.piscina.atrium.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlanningRestController {


    @Autowired
    private PlanningService service;
    
    @Autowired
    private PlanningDao dao;


  

}
