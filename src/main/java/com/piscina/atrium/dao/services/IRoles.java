package com.piscina.atrium.dao.services;

import com.piscina.atrium.models.Roles;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IRoles {

    public ArrayList<Roles> findRoles();
}
