package com.piscina.atrium.dao;

import com.piscina.atrium.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsDao extends JpaRepository<Payments,Long> {
}
