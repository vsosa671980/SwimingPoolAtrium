package com.piscina.atrium.dao;

import com.piscina.atrium.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesDao extends JpaRepository<Roles,Long> {

   Roles findByNameRole(String name);
}
