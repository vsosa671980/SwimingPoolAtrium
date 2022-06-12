package com.piscina.atrium.controllers;

import com.piscina.atrium.dao.services.RolesService;
import com.piscina.atrium.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class RolesController {

    @Autowired
    private RolesService service;

    public ArrayList<Roles> findRoles(){

        return service.findRoles();
    }


}
