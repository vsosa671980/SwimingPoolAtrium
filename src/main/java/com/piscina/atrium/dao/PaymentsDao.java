package com.piscina.atrium.dao;

import com.piscina.atrium.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PaymentsDao extends JpaRepository<Payments,Long> {

    @Query(value = "Select * From payments where payments.idusers = ?1",nativeQuery = true)
    ArrayList<Payments>listPaymentsByUser(@Param("id")Long iduser);
}
