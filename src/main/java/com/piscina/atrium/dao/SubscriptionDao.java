package com.piscina.atrium.dao;

import com.piscina.atrium.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface SubscriptionDao extends JpaRepository<Subscription,Long> {

    @Query(value="Select * From subscription Where subscription.idusers = ?1",nativeQuery = true)
    ArrayList<Subscription> listSubscriptionsByUser(Long id);


}
