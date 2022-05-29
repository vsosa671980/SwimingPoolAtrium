package com.piscina.atrium.dao;

import com.piscina.atrium.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDao extends JpaRepository<Subscription,Long> {
}
