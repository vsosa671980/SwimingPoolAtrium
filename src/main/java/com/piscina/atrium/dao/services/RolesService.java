package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.RolesDao;
import com.piscina.atrium.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class RolesService implements IRoles {


    @Autowired
    private RolesDao dao;
    @Override
    public ArrayList<Roles> findRoles() {
        return (ArrayList<Roles>) dao.findAll();
    }
}
