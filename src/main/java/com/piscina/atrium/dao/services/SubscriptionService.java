package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.SubscriptionDao;
import com.piscina.atrium.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SubscriptionService implements Isubscription {

     @Autowired
      private SubscriptionDao dao;

    @Override
    public void saveSubscription(Subscription sub) {
         dao.save(sub);
    }

    @Override
    public ArrayList<Subscription> listall() {
        return (ArrayList<Subscription>) dao.findAll();
    }

    @Override
    public void deleteSubscriprion(Subscription sub) {

        dao.delete(sub);

    }

    @Override
    public void update(Subscription sub) {

        dao.save(sub);
    }
}
