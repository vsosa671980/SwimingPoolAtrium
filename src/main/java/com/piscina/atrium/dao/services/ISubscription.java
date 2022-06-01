package com.piscina.atrium.dao.services;

import com.piscina.atrium.models.Subscription;

import java.util.ArrayList;

public interface Isubscription {

    public void saveSubscription(Subscription sub);


    public ArrayList<Subscription> listSubscriptionsUser(Long id);
    public ArrayList<Subscription> listall();

    public void deleteSubscriprion (Subscription sub);

    public void update(Subscription sub);
}
