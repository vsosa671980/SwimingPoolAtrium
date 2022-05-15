package com.piscina.atrium.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piscina.atrium.models.Subscription;

public interface SubscriptionDao extends JpaRepository<Subscription, Long> {

}
